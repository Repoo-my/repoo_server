package com.repoo.domain.education.service.implementation;

import com.repoo.domain.education.domain.Education;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationUpdater {

    public void update(Education updatableEducation, Education education) {
        updatableEducation.update(
                education.getSchoolName(),
                education.getDepartmentName(),
                education.getAdmission_day(),
                education.getGraduation_day()
        );
    }
}
