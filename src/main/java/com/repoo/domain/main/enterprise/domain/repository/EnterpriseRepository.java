package com.repoo.domain.main.enterprise.domain.repository;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
