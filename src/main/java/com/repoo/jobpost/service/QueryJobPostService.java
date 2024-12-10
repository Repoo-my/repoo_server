package com.repoo.jobpost.service;

import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.presentation.dto.respoonse.ResponseJobPost;
import com.repoo.jobpost.service.implementation.JobPostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryJobPostService {

    private final JobPostReader jobPostReader;

    public List<ResponseJobPost> getAllJobPosts() {
        List<JobPost> jobPosts = jobPostReader.findAll();
        List<ResponseJobPost> responseJobPosts = new ArrayList<>();

        for (JobPost jobPost : jobPosts) {
            responseJobPosts.add(new ResponseJobPost(
                    jobPost.getEnterprise().getEnterpriseName(),
                    jobPost.getJobGroup().getJobGroupName(),
                    jobPost.getJob().getJobName(),
                    jobPost.getMaxStanding(),
                    jobPost.getMinStanding(),
                    jobPost.getTitle(),
                    jobPost.getContents(),
                    jobPost.getJobpostImg()
            ));
        }

        return responseJobPosts;
    }

    public ResponseJobPost getJobPostsByJobId(Long jobPostId) {
        JobPost jobPost = jobPostReader.findById(jobPostId);
        return new ResponseJobPost(
                jobPost.getEnterprise().getEnterpriseName(),
                jobPost.getJobGroup().getJobGroupName(),
                jobPost.getJob().getJobName(),
                jobPost.getMaxStanding(),
                jobPost.getMinStanding(),
                jobPost.getTitle(),
                jobPost.getContents(),
                jobPost.getJobpostImg()
        );
    }

    public List<JobPost> getJobPostsByJobTitle(String jobTitle) {
        return jobPostReader.findByTitle(jobTitle);
    }
}
