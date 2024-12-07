package com.repoo.jobgroup.service.implementation;

import com.repoo.jobgroup.domain.JobGroup;
import com.repoo.jobpost.domain.JobPost;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobGroupUpdater {

    public void update(JobGroup updatableJobGroup, JobGroup jobGroup) {
        updatableJobGroup.update(
                jobGroup.getJobGroupName());
    }
}
