package com.repoo.curriculumvitae.presentation.dto.response;

import java.time.LocalDate;
import java.util.List;

public record ResponseDetailCurriculumVitae (
        String userName,
        String curriculumVitaeTitle,
        String curriculumVitaeIntroduction,
        String curriculumVitaeAddress,
        LocalDate curriculumVitaeDate,
        List<ResponseCareer> careers,
        List<ResponseEducation> educations,
        List<ResponseLanguage> languages
){
}
