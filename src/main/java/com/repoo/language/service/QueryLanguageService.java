package com.repoo.language.service;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.language.domain.Language;
import com.repoo.language.service.implementation.LanguageReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryLanguageService {

    private final LanguageReader languageReader;
    private final CurriculumVitaeReader curriculumVitaeReader;

    public Language getLanguage(Long id) {
        return languageReader.findById(id);
    }

    public List<Language> getLanguages() {
        return languageReader.findAll();
    }

    public List<Language> getLanguagesByCurriculumVitae(Long curriculumVitaeId) {
        return languageReader.findByCurriculumVitaeId(curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId));
    }

}
