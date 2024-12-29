package com.repoo.domain.main.curriculumvitae.service.implementation;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.curriculumvitae.domain.repository.CurriculumVitaeRepository;
import com.repoo.domain.main.curriculumvitae.exception.CurriculumVitaeNotFoundException;
import com.repoo.domain.main.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeReader {

    private final CurriculumVitaeRepository curriculumVitaeRepository;

    public CurriculumVitae getCurriculumVitae(Long id) {
        return curriculumVitaeRepository.findById(id)
                .orElseThrow(CurriculumVitaeNotFoundException::new);
    }

    public List<CurriculumVitae> getCurriculumVitaesByUser(Users user) {
        return curriculumVitaeRepository.getAllByUser(user);
    }
}
