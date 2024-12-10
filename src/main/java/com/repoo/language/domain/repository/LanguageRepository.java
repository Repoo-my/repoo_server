package com.repoo.language.domain.repository;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.language.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    public List<Language> findByCurriculumVitae(CurriculumVitae curriculumVitae);
}
