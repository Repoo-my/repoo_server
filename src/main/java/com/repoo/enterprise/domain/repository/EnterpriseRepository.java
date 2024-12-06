package com.repoo.enterprise.domain.repository;

import com.repoo.enterprise.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
