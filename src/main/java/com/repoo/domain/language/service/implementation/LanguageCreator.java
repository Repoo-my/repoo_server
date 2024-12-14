package com.repoo.domain.language.service.implementation;

import com.repoo.domain.language.domain.Language;
import com.repoo.domain.language.domain.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageCreator {

    private final LanguageRepository languageRepository;

    public void save(Language language) {
        languageRepository.save(language);
    }
}
