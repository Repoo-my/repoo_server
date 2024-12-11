package com.repoo.education.service.implementation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.education.domain.Education;
import com.repoo.education.domain.repository.EducationRepository;
import com.repoo.education.exception.EducationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationReader {

    private final EducationRepository educationRepository;

    public Education getEducation(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(EducationNotFoundException::new);
    }

    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    public List<Education> getEducationsByCurriculumVitae(CurriculumVitae curriculumVitae) {
        return educationRepository.getAllByCurriculumVitae(curriculumVitae);
    }
}
