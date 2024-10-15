package com.twentyone.steachserver.domain.member.service;

import com.twentyone.steachserver.domain.auth.dto.CheckUsernameAvailableResponse;
import com.twentyone.steachserver.domain.member.dto.StudentInfoRequest;
import com.twentyone.steachserver.domain.member.dto.StudentInfoResponse;
import com.twentyone.steachserver.domain.member.model.Student;

public interface StudentService {
    StudentInfoResponse getInfo(Student student);

    StudentInfoResponse updateInfo(StudentInfoRequest request, Student student);

    CheckUsernameAvailableResponse checkNicknameAvailability(String nickname);

    CheckUsernameAvailableResponse checkEmailAvailability(String email);
}
