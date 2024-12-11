package com.repoo.curriculumvitae.service;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCurriculumVitaeService {

    private final CurriculumVitaeReader curriculumVitaeReader;
    private final UsersReader usersReader;

    public CurriculumVitae getCurriculumVitae(Long id){
        return curriculumVitaeReader.getCurriculumVitae(id);
    }

    public List<CurriculumVitae> getCurriculumVitaesByUser(Long userId){
        return curriculumVitaeReader.getCurriculumVitaesByUser(usersReader.findById(userId));
    }
}
