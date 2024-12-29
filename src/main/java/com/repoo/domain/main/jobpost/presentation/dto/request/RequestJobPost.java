package com.repoo.domain.main.jobpost.presentation.dto.request;

public record RequestJobPost(
    Integer maxStanding,
    Integer minStanding,
    String title,
    String contents,
    String jobPostImg
) {}
