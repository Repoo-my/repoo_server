package com.repoo.domain.side.jobgroup.service;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import com.repoo.domain.side.jobgroup.service.implementation.JobGroupCreator;
import com.repoo.domain.side.jobgroup.service.implementation.JobGroupDeleter;
import com.repoo.domain.side.jobgroup.service.implementation.JobGroupReader;
import com.repoo.domain.side.jobgroup.service.implementation.JobGroupUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommandJobGroupService {

    private final JobGroupCreator jobGroupCreator;
    private final JobGroupDeleter jobGroupDeleter;
    private final JobGroupUpdater jobGroupUpdater;
    private final JobGroupReader jobGroupReader;

    public void create(JobGroup jobPost) {
        jobGroupCreator.save(jobPost);
    }

    public void update(JobGroup jobGroup) {
        JobGroup updatableJobGroup = jobGroupReader.findById(jobGroup.getJobGroupId());
        jobGroupUpdater.update(updatableJobGroup, jobGroup);
    }

    public void delete(JobGroup jobPost) {
        jobGroupDeleter.delete(jobPost);
    }
}
