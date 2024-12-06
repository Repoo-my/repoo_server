package com.repoo.jobpost.presentation;


import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.presentation.dto.RequestJobPost;
import com.repoo.jobpost.service.CommandJobPostService;
import com.repoo.jobpost.service.QueryJobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobPostController {

    private final CommandJobPostService commandJobPostService;
    private final QueryJobPostService queryJobPostService;

    @GetMapping("/api/jobposts")
    public List<JobPost> getAllJobPosts() {
        return queryJobPostService.getAllJobPosts();
    }

    @GetMapping("/api/jobpost/{jobPostId}")
    public JobPost getJobPostById(@PathVariable Long jobPostId) {
        return queryJobPostService.getJobPostsByJobId(jobPostId);
    }

    @PostMapping("/api/jobpost")
    public void createJobPost(
            @RequestParam Long enterpriseId,
            @RequestParam Long jobId,
            @RequestParam Long jobGroupId,
            @RequestBody RequestJobPost requestJobPost
    ) {
        commandJobPostService.create(enterpriseId, jobId, jobGroupId, requestJobPost);
    }

    @PutMapping("/api/jobpost/{jobPostId}")
    public void updateJobPost(
            @PathVariable Long jobPostId,
            @RequestBody RequestJobPost requestJobPost
    ){
        commandJobPostService.update(jobPostId, requestJobPost);
    }

    @DeleteMapping("/api/jobpost/{jobPostId}")
    public void deleteJobPost(
            @PathVariable Long jobPostId
    ){
        commandJobPostService.delete(jobPostId);
    }
}
