package com.repoo.jobpost.service;

import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.service.implementation.JobPostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryJobPostService {

    private final JobPostReader jobPostReader;

    public List<JobPost> getAllJobPosts() {
        return jobPostReader.findAll();
    }

    public JobPost getJobPostsByJobId(Long jobPostId) {
        return jobPostReader.findById(jobPostId);
    }

    public List<JobPost> getJobPostsByJobTitle(String jobTitle) {
        return jobPostReader.findByTitle(jobTitle);
    }
}
