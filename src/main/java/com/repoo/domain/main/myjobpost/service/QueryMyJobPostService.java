package com.repoo.domain.main.myjobpost.service;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseCurriculumVitae;
import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.presentation.dto.res.ResponseEnterprise;
import com.repoo.domain.main.jobpost.domain.JobPost;
import com.repoo.domain.main.jobpost.presentation.dto.respoonse.ResponseJobPost;
import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.presentation.dto.res.ResponseMyJobPost;
import com.repoo.domain.main.myjobpost.service.implementation.MyJobPostReader;
import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.presentation.dto.response.ResponseUserInfo;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMyJobPostService {

    private final MyJobPostReader myJobPostReader;
    private final UsersReader usersReader;

    public ResponseMyJobPost getMyJobPost(Long userId, Long myJobPostId) {
        MyJobPost myJobPost = myJobPostReader.findById(myJobPostId);

        if (myJobPost.getUser().getUsersId().equals(userId)) {
            return myJobPostToResponseMyJobPost(myJobPost);
        } else {
            return null;
        }
    }

    public List<ResponseMyJobPost> getMyJobPosts(Long userId) {
        List<MyJobPost> myJobPosts = myJobPostReader.findAllByUserId(usersReader.findById(userId));
        List<ResponseMyJobPost> responseMyJobPosts = new ArrayList<>();

        for (MyJobPost myJobPost : myJobPosts) {
            responseMyJobPosts.add(myJobPostToResponseMyJobPost(myJobPost));
        }

        return responseMyJobPosts;
    }

    public ResponseMyJobPost myJobPostToResponseMyJobPost(MyJobPost myJobPost) {
        Users user = myJobPost.getUser();
        Enterprise enterprise = myJobPost.getEnterprise();
        JobPost jobPost = myJobPost.getJobPost();
        CurriculumVitae curriculumVitae = myJobPost.getCurriculumVitae();

        ResponseUserInfo responseUser = new ResponseUserInfo(
                user.getUserName(),
                user.getUserEmail(),
                user.getUserGender(),
                user.getUserAge()
        );
        ResponseEnterprise responseEnterprise = new ResponseEnterprise(
                enterprise.getEnterpriseId(),
                enterprise.getEnterpriseName(),
                enterprise.getEnterpriseDescription(),
                enterprise.getEnterpriseEmail(),
                enterprise.getEnterprisePhone(),
                enterprise.getEnterpriseTags()
        );
        ResponseJobPost responseJobPost = new ResponseJobPost(
                jobPost.getEnterprise().getEnterpriseName(),
                jobPost.getJobGroup().getJobGroupName(),
                jobPost.getJob().getJobName(),
                jobPost.getMaxStanding(),
                jobPost.getMinStanding(),
                jobPost.getTitle(),
                jobPost.getContents(),
                jobPost.getSkills(),
                jobPost.getTags()
        );
        ResponseCurriculumVitae responseCurriculumVitae = new ResponseCurriculumVitae(
                curriculumVitae.getCurriculumVitaeTitle(),
                curriculumVitae.getCurriculumVitaeIntroduction(),
                curriculumVitae.getCurriculumVitaeUpdateDate()
        );

        return new ResponseMyJobPost(
                myJobPost.getMyJobPostId(),
                responseUser,
                responseEnterprise,
                responseJobPost,
                responseCurriculumVitae,
                myJobPost.getIsSubmit()
        );
    }
}
