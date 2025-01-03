package com.repoo.domain.side.jobgroup.service.implementation;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import com.repoo.domain.side.jobgroup.domain.repository.JobGroupRepository;
import com.repoo.domain.side.jobgroup.exception.JobGroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobGroupReader {

    private final JobGroupRepository jobGroupRepository;

    public JobGroup findById(long id) {
        return jobGroupRepository.findById(id)
                .orElseThrow(JobGroupNotFoundException::new);
    }

    public List<JobGroup> findAll() {
        return jobGroupRepository.findAll();
    }
}
