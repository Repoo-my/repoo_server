package com.repoo.jobpost.presentation.dto;

public record RequestJobPost(
    Integer maxStanding,
    Integer minStanding,
    String title,
    String contents,
    String jobpostImg
) {}
