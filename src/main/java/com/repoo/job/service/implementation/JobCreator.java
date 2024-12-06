package com.repoo.job.service.implementation;

import com.repoo.job.domain.Job;
import com.repoo.job.domain.repository.JobRepository;
import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.domain.repository.JobPostRepository;
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
