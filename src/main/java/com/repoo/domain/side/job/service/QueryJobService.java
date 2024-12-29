package com.repoo.domain.side.job.service;

import com.repoo.domain.side.job.domain.Job;
import com.repoo.domain.side.job.service.implementation.JobReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
