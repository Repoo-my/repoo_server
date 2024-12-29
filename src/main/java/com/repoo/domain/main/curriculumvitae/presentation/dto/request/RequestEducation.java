package com.repoo.domain.main.curriculumvitae.presentation.dto.request;

import java.time.LocalDate;

public record RequestEducation (
        String schoolName,
        String departmentName,
        LocalDate admission_day,
        LocalDate graduation_day
){
}
