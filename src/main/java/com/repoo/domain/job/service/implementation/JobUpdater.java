package com.repoo.domain.job.service.implementation;

import com.repoo.domain.job.domain.Job;
import com.repoo.domain.jobpost.domain.JobPost;
import org.springframework.stereotype.Service;

@Service
public class JobUpdater {

    public void update(Job updatableJob, Job job) {
        updatableJob.update(
                job.getJobGroup(),
                job.getJobName());
    }
}
