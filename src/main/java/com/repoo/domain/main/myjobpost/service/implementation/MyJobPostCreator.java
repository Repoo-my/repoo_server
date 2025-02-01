package com.repoo.domain.main.myjobpost.service.implementation;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.domain.repository.MyJobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyJobPostCreator {

    private final MyJobPostRepository myJobPostRepository;

    public void create(MyJobPost myJobPost) {
        myJobPostRepository.save(myJobPost);
    }

}
