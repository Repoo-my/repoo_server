package com.repoo.curriculumvitae.presentation.dto;

public record PostRequestCurriculumVitae(
        String curriculumVitaeTitle,
        String curriculumVitaeEmail,
        String curriculumVitaePhone,
        String curriculumVitaeIntroduction,
        String curriculumVitaeAddress
) {
}
