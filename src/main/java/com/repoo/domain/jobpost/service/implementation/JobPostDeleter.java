package com.repoo.domain.jobpost.service.implementation;

import com.repoo.domain.jobpost.domain.JobPost;
import com.repoo.domain.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobPostDeleter {

    private final JobPostRepository jobPostRepository;

    public void delete(JobPost jobPost) {
        jobPostRepository.delete(jobPost);
    }
}
