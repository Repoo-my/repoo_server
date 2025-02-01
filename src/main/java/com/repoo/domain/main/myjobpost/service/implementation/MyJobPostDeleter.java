package com.repoo.domain.main.myjobpost.service.implementation;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.domain.repository.MyJobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyJobPostDeleter {

    private final MyJobPostRepository myJobPostRepository;

    public void delete(MyJobPost myJobPost) {
        myJobPostRepository.delete(myJobPost);
    }
}
