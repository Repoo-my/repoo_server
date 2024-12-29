package com.repoo.domain.side.jobgroup.service.implementation;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import com.repoo.domain.side.jobgroup.domain.repository.JobGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobGroupDeleter {

    private final JobGroupRepository jobGroupRepository;

    public void delete(JobGroup jobGroup) {
        jobGroupRepository.delete(jobGroup);
    }
}
