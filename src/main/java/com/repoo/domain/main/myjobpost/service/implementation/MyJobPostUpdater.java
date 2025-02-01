package com.repoo.domain.main.myjobpost.service.implementation;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.domain.repository.MyJobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyJobPostUpdater {

    private final MyJobPostRepository myJobPostRepository;

    public void update(MyJobPost updatableMyJobPost, MyJobPost myJobPost) {
        updatableMyJobPost.update(
                myJobPost.getUser(),
                myJobPost.getEnterprise(),
                myJobPost.getJobPost(),
                myJobPost.getCurriculumVitae()
        );

        myJobPostRepository.save(updatableMyJobPost);
    }
}
