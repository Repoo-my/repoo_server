package com.repoo.curriculumvitae.service.implementation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeUpdater {

    public void update(CurriculumVitae updatableCurriculumVitae, CurriculumVitae curriculumVitae){
        updatableCurriculumVitae.update(
                curriculumVitae.getCurriculumVitaeTitle(),
                curriculumVitae.getCurriculumVitaeEmail(),
                curriculumVitae.getCurriculumVitaePhone(),
                curriculumVitae.getCurriculumVitaeIntroduction(),
                curriculumVitae.getCurriculumVitaeAddress()
        );
    }
}
