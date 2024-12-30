package com.repoo.domain.side.language.service;

import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseLanguage;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.domain.side.language.domain.Language;
import com.repoo.domain.side.language.service.implementation.LanguageReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ResponseLanguage> getLanguagesByCurriculumVitae(Long curriculumVitaeId) {
        List<Language> languages = languageReader.findByCurriculumVitae(curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId));

        List<ResponseLanguage> responseLanguages = new ArrayList<>();
        for (Language language : languages) {
            responseLanguages.add(new ResponseLanguage(
                    language.getLanguageName()
            ));
        }

        return responseLanguages;
    }

}
