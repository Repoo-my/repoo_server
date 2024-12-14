package com.repoo.curriculumvitae.presentation.dto.response;

import java.time.LocalDate;

public record ResponseEducation(
        String schoolName,
        String departmentName,
        LocalDate admission_day,
        LocalDate graduation_day
) {
}
