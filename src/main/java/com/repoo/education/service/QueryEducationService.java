package com.repoo.education.service;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.education.domain.Education;
import com.repoo.education.service.implementation.EducationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Education> getEducationsByCurriculumVitae(Long curriculumVitaeId) {
        return educationReader.getEducationsByCurriculumVitae(curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId));
    }
}
