package com.repoo.curriculumvitae.presentation.dto.response;

import java.time.LocalDate;

public record ResponseCurriculumVitae (
        String curriculumVitaeTitle,
        String curriculumVitaeIntroduction,
        LocalDate curriculumVitaeDate
){
}
