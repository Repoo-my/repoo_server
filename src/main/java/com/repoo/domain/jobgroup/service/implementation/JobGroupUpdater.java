package com.repoo.domain.jobgroup.service.implementation;

import com.repoo.domain.jobgroup.domain.JobGroup;
import com.repoo.domain.jobpost.domain.JobPost;
import org.springframework.stereotype.Service;

@Service
public class JobGroupUpdater {

    public void update(JobGroup updatableJobGroup, JobGroup jobGroup) {
        updatableJobGroup.update(
                jobGroup.getJobGroupName());
    }
}
