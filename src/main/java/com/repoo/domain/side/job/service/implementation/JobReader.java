package com.repoo.domain.side.job.service.implementation;

import com.repoo.domain.side.job.domain.Job;
import com.repoo.domain.side.job.domain.repository.JobRepository;
import com.repoo.domain.side.job.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobReader {

    private final JobRepository jobRepository;

    public Job findById(long id) {
        return jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
