package com.repoo.domain.main.curriculumvitae.service.implementation;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.curriculumvitae.domain.repository.CurriculumVitaeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CurriculumVitaeUpdater {

    private final CurriculumVitaeRepository curriculumVitaeRepository;

    public void update(CurriculumVitae updatableCurriculumVitae, CurriculumVitae curriculumVitae){
        updatableCurriculumVitae.update(
                curriculumVitae.getCurriculumVitaeTitle(),
                curriculumVitae.getCurriculumVitaeIntroduction(),
                curriculumVitae.getCurriculumVitaeAddress(),
                LocalDate.now(ZoneId.of("Asia/Seoul"))
        );

        curriculumVitaeRepository.save(updatableCurriculumVitae);
    }
}
