package com.repoo.domain.main.myjobpost.service;

import com.repoo.domain.main.curriculumvitae.service.QueryCurriculumVitaeService;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.domain.main.enterprise.service.QueryEnterpriseService;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseReader;
import com.repoo.domain.main.jobpost.service.QueryJobPostService;
import com.repoo.domain.main.jobpost.service.implementation.JobPostReader;
import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.presentation.dto.req.RequestMyJobPost;
import com.repoo.domain.main.myjobpost.presentation.dto.res.ResponseMyJobPost;
import com.repoo.domain.main.myjobpost.service.implementation.MyJobPostCreator;
import com.repoo.domain.main.myjobpost.service.implementation.MyJobPostDeleter;
import com.repoo.domain.main.myjobpost.service.implementation.MyJobPostReader;
import com.repoo.domain.main.myjobpost.service.implementation.MyJobPostUpdater;
import com.repoo.domain.main.user.service.QueryUsersService;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandMyJobPostService {

    private final MyJobPostCreator myJobPostCreator;
    private final MyJobPostUpdater myJobPostUpdater;
    private final MyJobPostDeleter myJobPostDeleter;
    private final MyJobPostReader myJobPostReader;

    private final UsersReader usersReader;
    private final EnterpriseReader enterpriseReader;
    private final JobPostReader jobPostReader;
    private final CurriculumVitaeReader curriculumVitaeReader;

    public void create(Long userId, RequestMyJobPost requestMyJobPost) {
        myJobPostCreator.create(new MyJobPost(
                usersReader.findById(userId),
                enterpriseReader.findById(requestMyJobPost.enterpriseId()),
                jobPostReader.findById(requestMyJobPost.jobPostId()),
                curriculumVitaeReader.getCurriculumVitae(requestMyJobPost.curriculumVitaeId()),
                requestMyJobPost.isSubmit()
        ));
    }

    public void update(Long userId, Long myJobPostId, RequestMyJobPost requestMyJobPost) {
        myJobPostUpdater.update(
                myJobPostReader.findById(myJobPostId),
                new MyJobPost(
                    usersReader.findById(userId),
                    enterpriseReader.findById(requestMyJobPost.enterpriseId()),
                    jobPostReader.findById(requestMyJobPost.jobPostId()),
                    curriculumVitaeReader.getCurriculumVitae(requestMyJobPost.curriculumVitaeId()),
                    requestMyJobPost.isSubmit()
                )
        );
    }

    public void delete(Long userId, Long myJobPostId) {
        MyJobPost myJobPost = myJobPostReader.findById(myJobPostId);

        if(myJobPost.getUser().getUsersId().equals(userId)) {
            myJobPostDeleter.delete(myJobPost);
        }
    }

}
