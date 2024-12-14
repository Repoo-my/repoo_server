package com.repoo.curriculumvitae.service.implementation;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeUpdater {

    public void update(CurriculumVitae updatableCurriculumVitae, CurriculumVitae curriculumVitae){
        updatableCurriculumVitae.update(
                curriculumVitae.getCurriculumVitaeTitle(),
                curriculumVitae.getCurriculumVitaeIntroduction(),
                curriculumVitae.getCurriculumVitaeAddress(),
                LocalDate.now(ZoneId.of("Asia/Seoul"))
        );
    }
}
