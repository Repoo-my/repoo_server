package com.repoo.domain.jobpost.service.implementation;

import com.repoo.domain.jobpost.domain.JobPost;
import org.springframework.stereotype.Service;

@Service
public class JobPostUpdater {

    public void update(JobPost updatableJobPost, JobPost jobPost) {
        updatableJobPost.update(
                jobPost.getJob(),
                jobPost.getJobGroup(),
                jobPost.getMaxStanding(),
                jobPost.getMinStanding(),
                jobPost.getTitle(),
                jobPost.getContents(),
                jobPost.getJobpostImg());
    }
}
