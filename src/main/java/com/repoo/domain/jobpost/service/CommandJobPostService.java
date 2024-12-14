package com.repoo.domain.jobpost.service;

import com.repoo.domain.enterprise.domain.Enterprise;
import com.repoo.domain.enterprise.service.implementation.EnterpriseReader;
import com.repoo.domain.job.domain.Job;
import com.repoo.domain.job.service.implementation.JobReader;
import com.repoo.domain.jobgroup.domain.JobGroup;
import com.repoo.domain.jobgroup.service.implementation.JobGroupReader;
import com.repoo.domain.jobpost.domain.JobPost;
import com.repoo.domain.jobpost.presentation.dto.request.RequestJobPost;
import com.repoo.domain.jobpost.service.implementation.JobPostCreator;
import com.repoo.domain.jobpost.service.implementation.JobPostDeleter;
import com.repoo.domain.jobpost.service.implementation.JobPostReader;
import com.repoo.domain.jobpost.service.implementation.JobPostUpdater;
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
