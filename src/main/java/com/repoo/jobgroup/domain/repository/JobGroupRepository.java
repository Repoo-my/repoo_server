package com.repoo.jobgroup.domain.repository;

import com.repoo.jobgroup.domain.JobGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobGroupRepository extends JpaRepository<JobGroup, Long> {
}
