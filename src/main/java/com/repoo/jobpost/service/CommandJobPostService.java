package com.repoo.jobpost.service;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.enterprise.service.implementation.EnterpriseReader;
import com.repoo.job.domain.Job;
import com.repoo.job.service.implementation.JobReader;
import com.repoo.jobgroup.domain.JobGroup;
import com.repoo.jobgroup.service.implementation.JobGroupReader;
import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.presentation.dto.request.RequestJobPost;
import com.repoo.jobpost.service.implementation.JobPostCreator;
import com.repoo.jobpost.service.implementation.JobPostDeleter;
import com.repoo.jobpost.service.implementation.JobPostReader;
import com.repoo.jobpost.service.implementation.JobPostUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommandJobPostService {

    private final JobPostCreator jobPostCreator;
    private final JobPostUpdater jobPostUpdater;
    private final JobPostDeleter jobPostDeleter;
    private final JobPostReader jobPostReader;

    private final EnterpriseReader enterpriseReader;
    private final JobReader jobReader;
    private final JobGroupReader jobGroupReader;

    public void create(Long enterpriseId, Long jobId, Long jobGroupId, RequestJobPost jobPost) {
        Enterprise enterprise = enterpriseReader.findById(enterpriseId);
        Job job = jobReader.findById(jobId);
        JobGroup jobGroup = jobGroupReader.findById(jobGroupId);

        jobPostCreator.save(new JobPost(
                enterprise,
                job,
                jobGroup,
                jobPost.maxStanding(),
                jobPost.minStanding(),
                jobPost.title(),
                jobPost.contents(),
                jobPost.jobPostImg()
        ));
    }

    public void update(Long jobPostId, RequestJobPost jobPost) {
        JobPost updatableJobPost = jobPostReader.findById(jobPostId);
        jobPostUpdater.update(
                updatableJobPost,
                new JobPost(
                        jobPostId,
                        updatableJobPost.getEnterprise(),
                        updatableJobPost.getJobGroup(),
                        updatableJobPost.getJob(),
                        jobPost.maxStanding(),
                        jobPost.minStanding(),
                        jobPost.title(),
                        jobPost.contents(),
                        jobPost.jobPostImg()
                ));
    }

    public void delete(Long jobPostId) {
        jobPostDeleter.delete(jobPostReader.findById(jobPostId));
    }
}
