package com.repoo.domain.side.language.service.implementation;

import com.repoo.domain.side.language.domain.Language;
import com.repoo.domain.side.language.domain.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageUpdater {

    private final LanguageRepository languageRepository;

    public void update(Language updatableLanguage, Language language) {
        updatableLanguage.update(
                language.getLanguageName()
        );

        languageRepository.save(language);
    }
}
