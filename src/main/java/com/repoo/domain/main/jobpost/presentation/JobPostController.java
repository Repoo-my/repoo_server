package com.repoo.domain.main.jobpost.presentation;


import com.repoo.domain.main.jobpost.presentation.dto.request.RequestJobPost;
import com.repoo.domain.main.jobpost.presentation.dto.respoonse.ResponseJobPost;
import com.repoo.domain.main.jobpost.service.CommandJobPostService;
import com.repoo.domain.main.jobpost.service.QueryJobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobPostController {

    private final CommandJobPostService commandJobPostService;
    private final QueryJobPostService queryJobPostService;

    @GetMapping("/api/jobposts")
    public List<ResponseJobPost> getAllJobPosts() {
        return queryJobPostService.getAllJobPosts();
    }

    @GetMapping("/api/jobpost/{jobPostId}")
    public ResponseJobPost getJobPostById(@PathVariable Long jobPostId) {
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
