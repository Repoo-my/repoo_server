package com.repoo.curriculumvitae.service.implementation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.domain.repository.CurriculumVitaeRepository;
import com.repoo.curriculumvitae.exception.CurriculumVitaeNotFoundException;
import com.repoo.user.domain.Users;
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
