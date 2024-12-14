package com.repoo.domain.curriculumvitae.presentation.dto.response;

import java.time.LocalDate;

public record ResponseCurriculumVitae (
        String curriculumVitaeTitle,
        String curriculumVitaeEmail,
        String curriculumVitaeIntroduction,
        LocalDate curriculumVitaeDate
){
}
