package com.twentyone.steachserver.domain.studentQuiz.model;

import com.twentyone.steachserver.domain.member.model.Student;
import com.twentyone.steachserver.domain.quiz.model.Quiz;
import com.twentyone.steachserver.domain.studentQuiz.dto.StudentQuizRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "students_quizzes")
public class StudentQuiz {
    @EmbeddedId
    private StudentQuizId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId") //  엔터티의 외래 키 필드를 포함된 기본 키 클래스의 해당 필드에 매핑합니다.
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quiz quiz;

    @Column(name = "score")
    private Integer score;

    @Column(name = "student_choice")
    private String studentChoice;

    protected StudentQuiz() {}

    private StudentQuiz(Student student, Quiz quiz) {
        this.id = StudentQuizId.createStudentQuizId(student.getId(), quiz.getId());
        this.student = student;
        this.quiz = quiz;
    }

    public static StudentQuiz createStudentQuiz(Student student, Quiz quiz, StudentQuizRequestDto requestDto) {
        StudentQuiz studentQuiz = new StudentQuiz(student, quiz);
        studentQuiz.score = requestDto.score() == null ? 0 : requestDto.score();
        studentQuiz.studentChoice = requestDto.studentChoice();
        return studentQuiz;
    }

    public void updateQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
