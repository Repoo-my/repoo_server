package com.repoo.domain.side.jobgroup.service.implementation;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import org.springframework.stereotype.Service;

@Service
public class JobGroupUpdater {

    public void update(JobGroup updatableJobGroup, JobGroup jobGroup) {
        updatableJobGroup.update(
                jobGroup.getJobGroupName());
    }
}
