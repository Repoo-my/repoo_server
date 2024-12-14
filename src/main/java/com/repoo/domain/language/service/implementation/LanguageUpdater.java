package com.repoo.domain.language.service.implementation;

import com.repoo.domain.language.domain.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageUpdater {

    public void update(Language updatableLanguage, Language language) {
        updatableLanguage.update(
                language.getLanguageName()
        );
    }
}
