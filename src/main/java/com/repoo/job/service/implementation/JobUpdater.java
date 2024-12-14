package com.repoo.job.service.implementation;

import com.repoo.job.domain.Job;
import org.springframework.stereotype.Service;

@Service
public class JobUpdater {

    public void update(Job updatableJob, Job job) {
        updatableJob.update(
                job.getJobGroup(),
                job.getJobName());
    }
}
