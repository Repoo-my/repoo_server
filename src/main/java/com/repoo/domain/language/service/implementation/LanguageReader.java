package com.repoo.domain.language.service.implementation;

import com.repoo.domain.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.language.domain.Language;
import com.repoo.domain.language.domain.repository.LanguageRepository;
import com.repoo.domain.language.exception.LanguageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageReader {

    private final LanguageRepository languageRepository;

    public Language findById(Long id) {
        return languageRepository.findById(id)
                .orElseThrow(LanguageNotFoundException::new);
    }

    public List<Language> findAll(){
        return languageRepository.findAll();
    }

    public List<Language> findByCurriculumVitaeId(CurriculumVitae curriculumVitae){
        return languageRepository.findAllByCurriculumVitae(curriculumVitae);
    }
}
