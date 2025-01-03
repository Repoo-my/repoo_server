package com.repoo.domain.main.curriculumvitae.presentation.dto.request;

import java.util.List;

public record RequestCurriculumVitae(
        String curriculumVitaeTitle,
        String curriculumVitaeIntroduction,
        String curriculumVitaeAddress,
        List<RequestEducation> requestEducations,
        List<RequestCareer> requestCareers,
        List<RequestLanguage> requestLanguages
) {
}
