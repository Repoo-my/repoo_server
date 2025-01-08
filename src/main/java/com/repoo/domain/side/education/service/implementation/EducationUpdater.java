package com.repoo.domain.side.education.service.implementation;

import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.domain.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationUpdater {

    private final EducationRepository educationRepository;

    public void update(Education updatableEducation, Education education) {
        updatableEducation.update(
                education.getSchoolName(),
                education.getDepartmentName(),
                education.getAdmission_day(),
                education.getGraduation_day()
        );

        educationRepository.save(education);
    }
}
