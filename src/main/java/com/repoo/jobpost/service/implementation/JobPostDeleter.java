package com.repoo.jobpost.service.implementation;

import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.domain.repository.JobPostRepository;
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
