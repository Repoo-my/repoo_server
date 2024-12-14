package com.repoo.domain.curriculumvitae.service.implementation;

import com.repoo.domain.curriculumvitae.domain.repository.CurriculumVitaeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeDeleter {

    private final CurriculumVitaeRepository curriculumVitaeRepository;

    public void delete(Long id){
        curriculumVitaeRepository.deleteById(id);
    }
}
