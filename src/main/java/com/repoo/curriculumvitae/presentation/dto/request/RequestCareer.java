package com.repoo.curriculumvitae.presentation.dto.request;

public record RequestCareer(
        String careerName,
        String careerType,
        String careerDepartment,
        String careerPosition,
        String careerStartDate,
        String careerEndDate,
        String retirementDescription,
        String careerDescription
){
}
