package com.repoo.domain.curriculumvitae.domain.repository;

import com.repoo.domain.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {
    List<CurriculumVitae> getAllByUser(Users user);
}
