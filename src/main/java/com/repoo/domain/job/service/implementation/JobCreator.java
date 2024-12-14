package com.repoo.domain.job.service.implementation;

import com.repoo.domain.job.domain.Job;
import com.repoo.domain.job.domain.repository.JobRepository;
import com.repoo.domain.jobpost.domain.JobPost;
import com.repoo.domain.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobCreator {

    private final JobRepository jobRepository;

    public void save(Job job) {
        jobRepository.save(job);
    }
}
