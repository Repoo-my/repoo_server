package com.repoo.domain.side.jobgroup.service;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import com.repoo.domain.side.jobgroup.service.implementation.JobGroupReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryJobGroupService {

    private final JobGroupReader jobGroupReader;

    public List<JobGroup> getAllJobGroups() {
        return jobGroupReader.findAll();
    }

    public JobGroup getJobGroupsByJobId(Long jobGroupId) {
        return jobGroupReader.findById(jobGroupId);
    }
}
