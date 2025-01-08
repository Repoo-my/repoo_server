package com.repoo.domain.main.jobpost.presentation.dto.respoonse;

public record ResponseJobPost(
        String enterpriseName,
        String jobGroupName,
        String jobName,
        Integer maxStanding,
        Integer minStanding,
        String title,
        String contents,
        String[] skills,
        String[] tags
//        String jobPostImg
){
}
