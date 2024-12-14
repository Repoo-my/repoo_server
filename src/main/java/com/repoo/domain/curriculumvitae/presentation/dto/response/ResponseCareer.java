package com.repoo.domain.curriculumvitae.presentation.dto.response;

public record ResponseCareer(
        String careerName,
        String careerType,
        String careerDepartment,
        String careerPosition,
        String careerStartDate,
        String careerEndDate,
        String retirementDescription,
        String careerDescription
) {
}
