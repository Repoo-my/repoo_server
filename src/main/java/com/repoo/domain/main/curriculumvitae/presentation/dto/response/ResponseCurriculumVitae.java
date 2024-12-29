package com.repoo.domain.main.curriculumvitae.presentation.dto.response;

import java.time.LocalDate;

public record ResponseCurriculumVitae (
        String curriculumVitaeTitle,
        String curriculumVitaeIntroduction,
        LocalDate curriculumVitaeDate
){
}
