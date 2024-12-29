package com.repoo.domain.side.language.service;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.side.language.domain.Language;
import com.repoo.domain.side.language.service.implementation.LanguageCreator;
import com.repoo.domain.side.language.service.implementation.LanguageDeleter;
import com.repoo.domain.side.language.service.implementation.LanguageReader;
import com.repoo.domain.side.language.service.implementation.LanguageUpdater;
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
