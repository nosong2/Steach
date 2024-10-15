package com.twentyone.steachserver.domain.studentQuiz.service;

import com.twentyone.steachserver.domain.member.model.Student;
import com.twentyone.steachserver.domain.studentQuiz.dto.StudentQuizRequestDto;
import com.twentyone.steachserver.domain.studentQuiz.model.StudentQuiz;

public interface StudentQuizService {
    StudentQuiz createStudentQuiz(Student student, Integer quizId, StudentQuizRequestDto requestDto) throws IllegalAccessException;

}
