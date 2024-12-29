package com.repoo.domain.main.jobpost.service.implementation;

import com.repoo.domain.main.jobpost.domain.JobPost;
import com.repoo.domain.main.jobpost.domain.repository.JobPostRepository;
import com.repoo.domain.main.jobpost.exception.JobPostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostReader {

    private final JobPostRepository jobPostRepository;

    public JobPost findById(long id) {
        return jobPostRepository.findById(id)
                .orElseThrow(JobPostNotFoundException::new);
    }

    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }

    public List<JobPost> findByTitle(String title) {
        return jobPostRepository.findByTitle(title);
    }
}
