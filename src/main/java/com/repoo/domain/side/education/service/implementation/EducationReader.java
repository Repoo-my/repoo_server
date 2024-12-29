package com.repoo.domain.side.education.service.implementation;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.domain.repository.EducationRepository;
import com.repoo.domain.side.education.exception.EducationNotFoundException;
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
