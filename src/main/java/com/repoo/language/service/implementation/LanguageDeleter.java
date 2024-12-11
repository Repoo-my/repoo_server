package com.repoo.language.service.implementation;

import com.repoo.language.domain.Language;
import com.repoo.language.domain.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageDeleter {

    private final LanguageRepository languageRepository;

    public void delete(Language language) {
        languageRepository.delete(language);
    }

}
