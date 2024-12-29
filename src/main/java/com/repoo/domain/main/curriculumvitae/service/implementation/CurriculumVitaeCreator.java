package com.repoo.domain.main.curriculumvitae.service.implementation;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.curriculumvitae.domain.repository.CurriculumVitaeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeCreator {

    private final CurriculumVitaeRepository curriculumVitaeRepository;

    public void save(CurriculumVitae curriculumVitae){
        curriculumVitaeRepository.save(curriculumVitae);
    }
}
