package com.repoo.domain.main.myjobpost.service.implementation;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.myjobpost.domain.repository.MyJobPostRepository;
import com.repoo.domain.main.myjobpost.exception.MyJobPostNotFoundException;
import com.repoo.domain.main.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyJobPostReader {

    private final MyJobPostRepository myJobPostRepository;

    public MyJobPost findById(Long id) {
        return myJobPostRepository.findById(id)
                .orElseThrow(MyJobPostNotFoundException::new);
    }

    public List<MyJobPost> findAll() {
        return myJobPostRepository.findAll();
    }

    public List<MyJobPost> findAllByUserId(Users user) {
        return myJobPostRepository.findAllByUser(user);
    }
}
