package com.repoo.jobgroup.service;

import com.repoo.jobgroup.domain.JobGroup;
import com.repoo.jobgroup.service.implementation.JobGroupCreator;
import com.repoo.jobgroup.service.implementation.JobGroupDeleter;
import com.repoo.jobgroup.service.implementation.JobGroupReader;
import com.repoo.jobgroup.service.implementation.JobGroupUpdater;
import com.repoo.jobpost.domain.JobPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public void update(JobGroup updatabeJobGroup) {
        JobGroup jobPost = jobGroupReader.findById(updatabeJobGroup.getJobGroupId());
        jobGroupUpdater.update(updatabeJobGroup, jobPost);
    }

    public void delete(JobGroup jobPost) {
        jobGroupDeleter.delete(jobPost);
    }
}
