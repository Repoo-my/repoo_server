package com.repoo.jobgroup.service.implementation;

import com.repoo.jobgroup.domain.JobGroup;
import com.repoo.jobgroup.domain.repository.JobGroupRepository;
import com.repoo.jobgroup.exception.JobGroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
