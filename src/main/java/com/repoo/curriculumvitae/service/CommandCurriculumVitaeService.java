package com.repoo.curriculumvitae.service;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.presentation.dto.PostRequestCurriculumVitae;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeCreator;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeDeleter;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeUpdater;
import com.repoo.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandCurriculumVitaeService {

    private final CurriculumVitaeUpdater curriculumVitaeUpdate;
    private final CurriculumVitaeCreator curriculumVitaeCreator;
    private final CurriculumVitaeDeleter curriculumVitaeDeleter;
    private final CurriculumVitaeReader curriculumVitaeReader;
    private final UsersReader usersReader;

    public void save(Long userId, PostRequestCurriculumVitae requestCurriculumVitae){
        curriculumVitaeCreator.save(new CurriculumVitae(
                usersReader.findById(userId),
                requestCurriculumVitae.curriculumVitaeTitle(),
                requestCurriculumVitae.curriculumVitaeEmail(),
                requestCurriculumVitae.curriculumVitaePhone(),
                requestCurriculumVitae.curriculumVitaeIntroduction(),
                requestCurriculumVitae.curriculumVitaeAddress()
        ));
    }

    public void update(Long id, CurriculumVitae curriculumVitae){
        curriculumVitaeUpdate.update(curriculumVitaeReader.getCurriculumVitae(id), curriculumVitae);
    }

    public void delete(Long id){
        curriculumVitaeDeleter.delete(id);
    }
}
