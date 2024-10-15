package com.twentyone.steachserver.domain.studentLecture.service;

import com.twentyone.steachserver.domain.lecture.model.Lecture;
import com.twentyone.steachserver.domain.lecture.repository.LectureQueryRepository;
import com.twentyone.steachserver.domain.lecture.repository.LectureRepository;
import com.twentyone.steachserver.domain.lecture.validator.LectureValidator;
import com.twentyone.steachserver.domain.member.repository.StudentRepository;
import com.twentyone.steachserver.domain.studentLecture.model.StudentLecture;
import com.twentyone.steachserver.domain.studentLecture.repository.StudentLectureQueryRepository;
import com.twentyone.steachserver.domain.studentLecture.repository.StudentLectureRepository;
import com.twentyone.steachserver.domain.member.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentLectureServiceImpl implements StudentLectureService {

    private final StudentLectureRepository studentLectureRepository;
    private final StudentLectureQueryRepository studentLectureQueryRepository;

    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    private final LectureValidator lectureValidator;
    private final LectureQueryRepository lectureQueryRepository;


    @Override
    @Transactional
    public void saveSleepTime(Integer studentId, Integer lectureId, Integer sleepTime) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        Student student = studentRepository.getReferenceById(studentId);

        lectureValidator.validateLectureOfLectureAuth(lecture, student);
        lectureValidator.validateFinishLecture(lecture);

        int lectureDurationMinutes = (int) Duration.between(lecture.getRealStartTime(), LocalDateTime.now()).toMinutes();

        studentLectureRepository.findByStudentIdAndLectureId(studentId, lectureId)
                .ifPresentOrElse(
                        studentLecture -> {
                            LocalDateTime updatedAt = studentLecture.getUpdatedAt();
                            int middleMinutes = (int) Duration.between(updatedAt, LocalDateTime.now()).toMinutes();
                            int plusSleepTime = middleMinutes - sleepTime;

                            //FIXME plusFocusTime이 마이너스가 되는 문제 발생!! 0으로 맞추도록 임시 설정
                            if (plusSleepTime < 0) {
                                plusSleepTime = 0;
                            }

                            Integer lastSleepTime = studentLecture.getFocusTime();

                            int newSleepTime = lastSleepTime + plusSleepTime;
                            if (newSleepTime > lectureDurationMinutes) {
                                studentLecture.updateNewFocusTime(lectureDurationMinutes);
                            } else {
                                studentLecture.sumFocusTime(newSleepTime);
                            }
                        },
                        () -> createAndSaveStudentLecture(studentId, lectureId, sleepTime, lectureDurationMinutes)
                );
    }

    private void createAndSaveStudentLecture(Integer studentId, Integer lectureId, Integer sleepTime, Integer lectureDurationMinutes) {
        Lecture lecture = lectureRepository.getReferenceById(lectureId);
        Student student = studentRepository.getReferenceById(studentId);
        StudentLecture studentLecture = StudentLecture.of(student, lecture, sleepTime, lectureDurationMinutes);
        studentLectureRepository.save(studentLecture);
    }

    @Override
    @Transactional
    public void updateStudentLectureByFinishLecture(Integer lectureId) {
        studentLectureQueryRepository.updateStudentLectureByFinishLecture(lectureId);
    }

//    @Override
//    @Transactional
//    public void createStudentLectureByLecture(Integer lectureId) {
//        List<Student> students = lectureQueryRepository.getStudentIds(lectureId);
//
//        for (Student student : students) {
//            studentLectureRepository.save(StudentLecture.of(student, lectureRepository.getReferenceById(lectureId)));
//        }
//    }
}
