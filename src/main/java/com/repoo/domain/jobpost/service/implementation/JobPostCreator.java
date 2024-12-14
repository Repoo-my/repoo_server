package com.repoo.domain.jobpost.service.implementation;

import com.repoo.domain.jobpost.domain.JobPost;
import com.repoo.domain.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobPostCreator {

    private final JobPostRepository jobPostRepository;

    public void save(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }
}
