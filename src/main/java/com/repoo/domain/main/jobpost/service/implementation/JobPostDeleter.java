package com.repoo.domain.main.jobpost.service.implementation;

import com.repoo.domain.main.jobpost.domain.JobPost;
import com.repoo.domain.main.jobpost.domain.repository.JobPostRepository;
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
