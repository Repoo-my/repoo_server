package com.repoo.jobpost.presentation.dto.respoonse;

public record ResponseJobPost(
        String enterpriseName,
        String jobGroupName,
        String jobName,
        Integer maxStanding,
        Integer minStanding,
        String title,
        String contents,
        String jobPostImg
){
}
