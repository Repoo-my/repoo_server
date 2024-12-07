package com.repoo.job.service.implementation;

import com.repoo.job.domain.Job;
import com.repoo.jobpost.domain.JobPost;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobUpdater {

    public void update(Job updatableJob, Job job) {
        updatableJob.update(
                job.getJobGroup(),
                job.getJobName());
    }
}
