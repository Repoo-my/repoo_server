package com.repoo.domain.main.myjobpost.presentation.dto.req;

public record RequestMyJobPost(
        Long enterpriseId,
        Long jobPostId,
        Long curriculumVitaeId,
        Boolean isSubmit
) {
}
