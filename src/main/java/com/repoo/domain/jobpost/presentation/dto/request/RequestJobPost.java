package com.repoo.domain.jobpost.presentation.dto.request;

public record RequestJobPost(
    Integer maxStanding,
    Integer minStanding,
    String title,
    String contents,
    String jobPostImg
) {}
