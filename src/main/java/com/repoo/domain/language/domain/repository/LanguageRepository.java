package com.repoo.domain.language.domain.repository;

import com.repoo.domain.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.language.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findAllByCurriculumVitae(CurriculumVitae curriculumVitae);
}
