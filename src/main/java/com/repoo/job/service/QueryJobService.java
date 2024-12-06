package com.repoo.job.service;

import com.repoo.job.domain.Job;
import com.repoo.job.service.implementation.JobReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryJobService {

    private final JobReader jobReader;

    public List<Job> getAllJobs() {
        return jobReader.findAll();
    }

    public Job getJobsByJobId(Long jobId) {
        return jobReader.findById(jobId);
    }
}
