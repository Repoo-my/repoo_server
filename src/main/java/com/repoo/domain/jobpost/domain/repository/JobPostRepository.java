package com.repoo.domain.jobpost.domain.repository;

import com.repoo.domain.jobpost.domain.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    public List<JobPost> findByTitle(String title);
}
