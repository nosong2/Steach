package com.twentyone.steachserver.domain.curriculum.service;

import com.twentyone.steachserver.domain.auth.error.ForbiddenException;
import com.twentyone.steachserver.domain.auth.model.LoginCredential;
import com.twentyone.steachserver.domain.curriculum.dto.*;
import com.twentyone.steachserver.domain.curriculum.error.DuplicatedCurriculumRegistrationException;
import com.twentyone.steachserver.domain.curriculum.model.Curriculum;
import com.twentyone.steachserver.domain.curriculum.model.CurriculumDetail;
import com.twentyone.steachserver.domain.curriculum.repository.*;
import com.twentyone.steachserver.domain.curriculum.validator.CurriculumValidator;
import com.twentyone.steachserver.domain.lecture.model.Lecture;
import com.twentyone.steachserver.domain.lecture.repository.LectureRepository;
import com.twentyone.steachserver.domain.member.model.Student;
import com.twentyone.steachserver.domain.member.model.Teacher;
import com.twentyone.steachserver.domain.member.repository.TeacherRepository;
import com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculum;
import com.twentyone.steachserver.domain.studentCurriculum.model.StudentCurriculumId;
import com.twentyone.steachserver.domain.studentCurriculum.repository.StudentCurriculumRepository;
import com.twentyone.steachserver.domain.studentLecture.model.StudentLecture;
import com.twentyone.steachserver.domain.studentLecture.repository.StudentLectureRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.twentyone.steachserver.global.error.ResourceNotFoundException;
import com.twentyone.steachserver.util.converter.WeekdayBitmaskUtil;
import com.twentyone.steachserver.domain.curriculum.service.redis.CurriculumRedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.twentyone.steachserver.domain.curriculum.dto.CurriculumListResponse.fromSimpleDomainList;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CurriculumServiceImpl implements CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final CurriculumSearchRepository curriculumSearchRepository;
    private final LectureRepository lectureRepository;
    private final CurriculumDetailRepository curriculumDetailRepository;
    private final StudentCurriculumRepository studentCurriculumRepository;
    private final StudentLectureRepository studentLectureRepository;

    private final CurriculumValidator curriculumValidator;
    private final CurriculumRedisService curriculumRedisService;
    private final TeacherRepository teacherRepository;

    @Override
    @Transactional(readOnly = true)
    public CurriculumDetailResponse getDetail(Integer id) {
        Curriculum curriculum = curriculumRepository.findByIdWithDetail(id)
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));
        return CurriculumDetailResponse.fromDomain(curriculum);
    }

    @Override
    @Transactional
    public CurriculumDetailResponse create(LoginCredential loginCredential, CurriculumAddRequest request) {
        curriculumValidator.validatorMaxAttendees(request);
        //bitmask byte로 변환
        //이진수 문자열을 정수로 변환
        Byte weekdaysBitmask = WeekdayBitmaskUtil.convert(request.getWeekdaysBitmask());

        //detail 만들기
        CurriculumDetail curriculumDetail = CurriculumDetail.builder()
                .subTitle(request.getSubTitle())
                .intro(request.getIntro())
                .subCategory(request.getSubCategory())
                .information(request.getInformation())
                .bannerImgUrl(request.getBannerImgUrl())
                .weekdaysBitmask(weekdaysBitmask)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .lectureStartTime(request.getLectureStartTime())
                .lectureCloseTime(request.getLectureEndTime())
                .maxAttendees(request.getMaxAttendees())
                .build();
        curriculumDetailRepository.save(curriculumDetail);

        Curriculum curriculum = Curriculum.of(request.getTitle(), request.getCategory(), (Teacher) loginCredential,
                curriculumDetail);
        curriculumRepository.save(curriculum);

        //lecture 만들기
        //날짜 오름차순대로 들어감
        List<LocalDateTime> selectedDates = getSelectedWeekdays(request.getStartDate().atStartOfDay(), request.getEndDate().atStartOfDay(),
                weekdaysBitmask);

        for (int i = 0; i < selectedDates.size(); i++) {
            LocalDateTime lectureDate = selectedDates.get(i).with(curriculumDetail.getLectureStartTime()); // 날짜에 시간 설정
            LocalDateTime lectureEndDate = selectedDates.get(i).with(curriculumDetail.getLectureCloseTime()); // 날짜에 시간 설정
            int order = i + 1;
            Lecture lecture = Lecture.of(request.getTitle() + " " + order + "강", order,
                    lectureDate, lectureEndDate, curriculum);
            lectureRepository.save(lecture);
        }

        // Redis에 최신 커리큘럼 추가
        curriculumRedisService.addLatestCurriculum(CurriculumDetailResponse.fromDomainBySimple(curriculum));

        return CurriculumDetailResponse.fromDomain(curriculum); //관련 강의도 줄까?? 고민
    }


    @Override
    @Transactional
    public void registration(LoginCredential loginCredential, Integer curriculaId) {
        if (!(loginCredential instanceof Student)) {
            throw new RuntimeException("학생만 수강신청이 가능합니다.");
        }

        Student student = (Student) loginCredential;

        Curriculum curriculum = curriculumRepository.findByIdWithLock(curriculaId)
                .orElseThrow(() -> new RuntimeException("찾을 수 없음"));

        if (curriculum.getCurriculumDetail().getMaxAttendees() <= curriculum.getCurriculumDetail()
                .getCurrentAttendees()) {
            throw new RuntimeException("수강정원이 다 찼습니다.");
        }

        studentCurriculumRepository.findTop1ByStudentAndCurriculum(student, curriculum)
                .ifPresent(sc -> {
                    throw new DuplicatedCurriculumRegistrationException("중복 수강신청 불가능");
                });

        StudentCurriculum studentCurriculum = new StudentCurriculum(student, curriculum);

        if (curriculum.getLectures() != null) {
            for (Lecture lecture : curriculum.getLectures()) {
                studentLectureRepository.save(StudentLecture.of(student, lecture));
            }
        }

        studentCurriculumRepository.save(studentCurriculum);

        curriculum.register();
    }

    @Override
    public void cancel(Student student, Integer curriculaId) {
        Curriculum curriculum = curriculumRepository.findByIdWithLock(curriculaId)
                .orElseThrow(() -> new RuntimeException("커리큘럼 찾을 수 없음"));

        studentCurriculumRepository.deleteByStudentAndCurriculumWithException(student, curriculum);

        CurriculumDetail curriculumDetail = curriculum.getCurriculumDetail();
        curriculumDetail.minusCurrentAttendees();
    }


    @Override
    @Transactional(readOnly = true)
    public CurriculumListResponse getTeachersCurricula(Teacher teacher, Pageable pageable) {
        Page<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher, pageable);

        return CurriculumListResponse.fromDomainList(curriculumList);
    }

    @Override
    @Transactional(readOnly = true)
    public CurriculumListResponse getTeachersCurricula(Teacher teacher) {
        List<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher);

        return CurriculumListResponse.fromDomainList(curriculumList);
    }

    @Override
    public CurriculumListResponse getTeachersCurricula(Integer teacherId, Pageable pageable) {
        Teacher teacher = teacherRepository.getReferenceById(teacherId);
        Page<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher, pageable);

        return CurriculumListResponse.fromSimpleDomainList(curriculumList);
    }

    @Override
    public CurriculumListResponse getTeachersCurricula(Integer teacherId) {
        Teacher teacher = teacherRepository.getReferenceById(teacherId);
        List<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher);

        return CurriculumListResponse.fromSimpleDomainList(curriculumList);
    }

    @Override
    @Transactional(readOnly = true)
    public CurriculumListResponse getStudentsCurricula(Student student, Pageable pageable) {
        Page<StudentCurriculum> studentsCurriculaPage = studentCurriculumRepository.findByStudent(student, pageable);
        List<StudentCurriculum> studentsCurricula = studentsCurriculaPage.getContent();

        List<Curriculum> curriculaList = new ArrayList<>();
        for (StudentCurriculum studentCurriculum : studentsCurricula) {
            curriculaList.add(studentCurriculum.getCurriculum());
        }

        return CurriculumListResponse.fromDomainList(curriculaList, studentsCurriculaPage.getPageable().getPageNumber(),
                studentsCurriculaPage.getTotalPages(), studentsCurriculaPage.getPageable().getPageSize());
    }

    @Override
    @Transactional(readOnly = true)
    public CurriculumListResponse getStudentsCurricula(Student student) {
        List<StudentCurriculum> studentsCurricula = studentCurriculumRepository.findByStudent(student);

        List<Curriculum> curriculaList = new ArrayList<>();
        for (StudentCurriculum studentCurriculum : studentsCurricula) {
            curriculaList.add(studentCurriculum.getCurriculum());
        }

        return CurriculumListResponse.fromDomainList(curriculaList, null, null, null);
    }

    @Override
    public CurriculumListResponse search(CurriculaSearchCondition condition, Pageable pageable) {
        //페이징 처리
        Page<Curriculum> curriculumList = curriculumSearchRepository.search(condition, pageable);

        return fromSimpleDomainList(curriculumList);
    }

    @Override
    public CurriculumListResponse search(CurriculaSearchCondition condition) {
        //페이징 없이 처리
        List<Curriculum> curriculumList = curriculumSearchRepository.search(condition);

        return fromSimpleDomainList(curriculumList);
    }

    @Override
    public List<LocalDateTime> getSelectedWeekdays(LocalDateTime startDate, LocalDateTime endDate,
                                                   int weekdaysBitmask) {
        List<LocalDateTime> selectedDates = new ArrayList<>();

        for (LocalDateTime date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int dayOfWeekValue = getBitmaskForDayOfWeek(dayOfWeek);

            if ((weekdaysBitmask & dayOfWeekValue) != 0) {
                selectedDates.add(date);
            }
        }

        return selectedDates;
    }

    @Transactional
    @Override
    public CurriculumDetailResponse updateCurriculum(Integer curriculumId, Teacher teacher, CurriculumAddRequest request) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new RuntimeException("해당하는 커리큘럼이 없습니다"));//TODO 404

        if (!curriculum.getTeacher().equals(teacher)) {
            throw new ForbiddenException("권한이 없는 접근");
        }

        //null일 경우 update되지 않음
        curriculum.update(
                request.getTitle(),
                request.getSubTitle(),
                request.getIntro(),
                request.getInformation(),
                request.getCategory(),
                request.getSubCategory(),
                request.getBannerImgUrl(),
                request.getStartDate(),
                request.getEndDate(),
                request.getWeekdaysBitmask(),
                request.getLectureStartTime(),
                request.getLectureEndTime(),
                request.getMaxAttendees()
        );

        return CurriculumDetailResponse.fromDomain(curriculum);
    }

    @Override
    @Transactional
    public void deleteCurriculum(Teacher teacher, Integer curriculumId) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new ResourceNotFoundException("커리큘럼을 찾을 수 없음"));

        if (!curriculum.getTeacher().equals(teacher)) {
            throw new ForbiddenException("커리큘럼을 만든 사람이 아님. 권한없음");
        }

        curriculumRepository.delete(curriculum);

        //
//        최신 7개 중 하나가 빠지면, 채워 넣어야함.
        List<CurriculumDetailResponse> latestCurriculums = curriculumRedisService.getLatestCurricula();
        for (CurriculumDetailResponse latestCurriculumsCurriculum : latestCurriculums) {
            if (latestCurriculumsCurriculum.getCurriculumId().equals(curriculumId)) {
                List<Curriculum> top7ByOrderByCurricula = curriculumSearchRepository.findTop7ByOrderByCurricula(CurriculaOrderType.LATEST);
                curriculumRedisService.saveLatestCurricula(fromSimpleDomainList(top7ByOrderByCurricula).getCurricula());
                break;
            }
        }
    }

    @Transactional(readOnly = true)
    public List<CurriculumDetailResponse> getPopularRatioCurriculums() {
        List<Curriculum> curriculumList = curriculumSearchRepository.findTop7ByOrderByCurricula(CurriculaOrderType.POPULAR_PER_RATIO);

        return fromSimpleDomainList(curriculumList).getCurricula();
    }

    @Override
    public List<CurriculumDetailResponse> getLatestCurriculums() {
        List<Curriculum> curriculumList = curriculumSearchRepository.findTop7ByOrderByCurricula(CurriculaOrderType.LATEST);

        return fromSimpleDomainList(curriculumList).getCurricula();
    }

    @Override
    public Boolean getIsApplyForCurriculum(Student student, Integer curriculumId) {
        return studentCurriculumRepository.existsById(StudentCurriculumId.createStudentCurriculumId(student.getId(), curriculumId));
    }


    @Override
    @Transactional(readOnly = true)
    public CurriculumIncludesStudentListResponseDto getTeachersCurriculaIncludesStudents(Teacher teacher, Pageable pageable) {
        List<CurriculumIncludesStudentDto> curriculumDtoList = new ArrayList<>();
        Page<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher, pageable);
        for (Curriculum curriculum : curriculumList) {
            List<StudentCurriculum> studentCurriculumList = studentCurriculumRepository.findAllByCurriculumId(curriculum.getId());
            CurriculumIncludesStudentDto curriculumIncludesStudentDto = CurriculumIncludesStudentDto.of(curriculum, studentCurriculumList);
            curriculumDtoList.add(curriculumIncludesStudentDto);
        }
        return CurriculumIncludesStudentListResponseDto.of(curriculumDtoList);
    }

    @Override
    @Transactional(readOnly = true)
    public CurriculumIncludesStudentListResponseDto getTeachersCurriculaIncludesStudents(Teacher teacher) {
        List<CurriculumIncludesStudentDto> curriculumDtoList = new ArrayList<>();
        List<Curriculum> curriculumList = curriculumRepository.findAllByTeacher(teacher);
        for (Curriculum curriculum : curriculumList) {
            List<StudentCurriculum> studentCurriculumList = studentCurriculumRepository.findAllByCurriculumId(curriculum.getId());
            CurriculumIncludesStudentDto curriculumIncludesStudentDto = CurriculumIncludesStudentDto.of(curriculum, studentCurriculumList);
            curriculumDtoList.add(curriculumIncludesStudentDto);
        }
        return CurriculumIncludesStudentListResponseDto.of(curriculumDtoList);
    }


    private int getBitmaskForDayOfWeek(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> 64; // 1000000
            case TUESDAY -> 32; // 0100000
            case WEDNESDAY -> 16; // 0010000
            case THURSDAY -> 8;  // 0001000
            case FRIDAY -> 4;  // 0000100
            case SATURDAY -> 2;  // 0000010
            case SUNDAY -> 1;  // 0000001
            default -> 0;
        };
    }
}
