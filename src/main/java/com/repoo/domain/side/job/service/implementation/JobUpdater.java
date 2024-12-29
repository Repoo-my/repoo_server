package com.repoo.domain.side.job.service.implementation;

import com.repoo.domain.side.job.domain.Job;
import org.springframework.stereotype.Service;

@Service
public class JobUpdater {

    public void update(Job updatableJob, Job job) {
        updatableJob.update(
                job.getJobGroup(),
                job.getJobName());
    }
}
