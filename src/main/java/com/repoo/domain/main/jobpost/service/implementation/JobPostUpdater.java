package com.repoo.domain.main.jobpost.service.implementation;

import com.repoo.domain.main.jobpost.domain.JobPost;
import com.repoo.domain.main.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobPostUpdater {

    private final JobPostRepository jobPostRepository;

    public void update(JobPost updatableJobPost, JobPost jobPost) {
        updatableJobPost.update(
                jobPost.getJob(),
                jobPost.getJobGroup(),
                jobPost.getMaxStanding(),
                jobPost.getMinStanding(),
                jobPost.getTitle(),
                jobPost.getContents(),
                jobPost.getJobpostImg());

        jobPostRepository.save(jobPost);
    }
}
