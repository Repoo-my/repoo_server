package com.repoo.domain.side.jobgroup.service.implementation;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import com.repoo.domain.side.jobgroup.domain.repository.JobGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobGroupCreator {

    private final JobGroupRepository JobGroupRepository;

    public void save(JobGroup jobGroup) {
        JobGroupRepository.save(jobGroup);
    }
}
