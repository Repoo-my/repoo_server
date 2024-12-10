package com.repoo.language.service.implementation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.language.domain.Language;
import com.repoo.language.domain.repository.LanguageRepository;
import com.repoo.language.exception.LanguageNotFoundException;
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
        return languageRepository.findByCurriculumVitae(curriculumVitae);
    }
}
