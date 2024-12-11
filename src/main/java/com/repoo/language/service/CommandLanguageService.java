package com.repoo.language.service;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.language.domain.Language;
import com.repoo.language.service.implementation.LanguageCreator;
import com.repoo.language.service.implementation.LanguageDeleter;
import com.repoo.language.service.implementation.LanguageReader;
import com.repoo.language.service.implementation.LanguageUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandLanguageService {

    private final LanguageCreator languageCreator;
    private final LanguageDeleter languageDeleter;
    private final LanguageUpdater  languageUpdater;
    private final LanguageReader languageReader;

    public void save(CurriculumVitae curriculumVitae, String languageName){
        languageCreator.save(new Language(curriculumVitae, languageName));
    }

    public void update(Long languageId, Language language){
        languageUpdater.update(languageReader.findById(languageId), language);
    }

    public void delete(Long languageId){
        languageDeleter.delete(languageReader.findById(languageId));
    }

}
