package com.repoo.job.service.implementation;

import com.repoo.job.domain.Job;
import com.repoo.job.domain.repository.JobRepository;
import com.repoo.job.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
