package com.repoo.domain.education.domain.repository;

import com.repoo.domain.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.education.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> getAllByCurriculumVitae(CurriculumVitae curriculumVitae);
}
