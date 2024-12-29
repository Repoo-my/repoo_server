package com.repoo.domain.side.education.service;

import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseEducation;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.service.implementation.EducationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryEducationService {

    private final EducationReader educationReader;
    private final CurriculumVitaeReader curriculumVitaeReader;

    public Education getEducation(Long id) {
        return educationReader.getEducation(id);
    }

    public List<Education> getEducations() {
        return educationReader.getEducations();
    }

    public List<ResponseEducation> getEducationsByCurriculumVitae(Long curriculumVitaeId) {
        List<Education> educations = educationReader.getEducationsByCurriculumVitae(
                curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId)
        );

        List<ResponseEducation> responseEducations = new ArrayList<>();
        for (Education education : educations) {
            responseEducations.add(new ResponseEducation(
                    education.getSchoolName(),
                    education.getDepartmentName(),
                    education.getAdmission_day(),
                    education.getGraduation_day()
            ));
        }

        return responseEducations;
    }
}
