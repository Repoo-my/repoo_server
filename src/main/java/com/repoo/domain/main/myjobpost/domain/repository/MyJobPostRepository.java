package com.repoo.domain.main.myjobpost.domain.repository;

import com.repoo.domain.main.myjobpost.domain.MyJobPost;
import com.repoo.domain.main.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyJobPostRepository extends JpaRepository<MyJobPost, Long> {
    List<MyJobPost> findAllByUser(Users user);
}
