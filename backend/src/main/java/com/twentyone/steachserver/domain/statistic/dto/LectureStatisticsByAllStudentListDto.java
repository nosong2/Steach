package com.twentyone.steachserver.domain.statistic.dto;

import java.util.List;

public record LectureStatisticsByAllStudentListDto(
        List<LectureStatisticsByAllStudentDto> lectureStatisticsByAllStudentDtoList) {
}
