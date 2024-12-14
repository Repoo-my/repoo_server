package com.repoo.domain.curriculumvitae.presentation.dto.request;

public record RequestCurriculumVitae(
        String curriculumVitaeTitle,
        String curriculumVitaeEmail,
        String curriculumVitaePhone,
        String curriculumVitaeIntroduction,
        String curriculumVitaeAddress
) {
}
