package com.repoo.job.service;

import com.repoo.job.domain.Job;
import com.repoo.job.service.implementation.JobCreator;
import com.repoo.job.service.implementation.JobDeleter;
import com.repoo.job.service.implementation.JobReader;
import com.repoo.job.service.implementation.JobUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommandJobService {

    private final JobCreator jobCreator;
    private final JobUpdater jobUpdater;
    private final JobDeleter jobDeleter;
    private final JobReader jobReader;

    public void create(Job job) {
        jobCreator.save(job);
    }

    public void update(Job updatabeJob) {
        Job job = jobReader.findById(updatabeJob.getJobId());
        jobUpdater.update(updatabeJob, job);
    }

    public void delete(Job job) {
        jobDeleter.delete(job);
    }
}
