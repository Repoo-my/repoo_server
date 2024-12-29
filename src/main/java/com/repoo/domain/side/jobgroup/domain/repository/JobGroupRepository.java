package com.repoo.domain.side.jobgroup.domain.repository;

import com.repoo.domain.side.jobgroup.domain.JobGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobGroupRepository extends JpaRepository<JobGroup, Long> {
}
