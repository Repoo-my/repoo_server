package com.repoo.domain.side.career.domain.repository;

import com.repoo.domain.side.career.domain.Career;
import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByCurriculumVitae(CurriculumVitae curriculumVitae);
}
