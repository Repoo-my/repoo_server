package com.repoo.domain.main.curriculumvitae.service;

import com.repoo.domain.side.career.domain.Career;
import com.repoo.domain.side.career.service.CommandCareerService;
import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestCareer;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestCurriculumVitae;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestEducation;
import com.repoo.domain.main.curriculumvitae.presentation.dto.request.RequestLanguage;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeCreator;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeDeleter;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeUpdater;
import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.service.CommandEducationService;
import com.repoo.domain.side.language.service.CommandLanguageService;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CommandCurriculumVitaeService {

    private final CurriculumVitaeUpdater curriculumVitaeUpdate;
    private final CurriculumVitaeCreator curriculumVitaeCreator;
    private final CurriculumVitaeDeleter curriculumVitaeDeleter;
    private final CurriculumVitaeReader curriculumVitaeReader;
    private final CommandCareerService commandCareerService;
    private final CommandEducationService commandEducationService;
    private final CommandLanguageService commandLanguageService;
    private final UsersReader usersReader;

    public void save(
            Long userId,
            RequestCurriculumVitae requestCurriculumVitae,
            RequestEducation requestEducation,
            RequestCareer requestCareer,
            RequestLanguage requestLanguage
    ){
        CurriculumVitae curriculumVitae = new CurriculumVitae(
                usersReader.findById(userId),
                requestCurriculumVitae.curriculumVitaeTitle(),
                requestCurriculumVitae.curriculumVitaeIntroduction(),
                requestCurriculumVitae.curriculumVitaeAddress(),
                LocalDate.now(ZoneId.of("Asia/Seoul"))
        );
        curriculumVitaeCreator.save(curriculumVitae);

        commandCareerService.save(new Career(
                curriculumVitae,
                requestCareer.careerName(),
                requestCareer.careerType(),
                requestCareer.careerDepartment(),
                requestCareer.careerPosition(),
                requestCareer.careerStartDate(),
                requestCareer.careerEndDate(),
                requestCareer.retirementDescription(),
                requestCareer.careerDescription()
        ));

        commandEducationService.save(new Education(
                curriculumVitae,
                requestEducation.schoolName(),
                requestEducation.departmentName(),
                requestEducation.admission_day(),
                requestEducation.graduation_day()
        ));

        commandLanguageService.save(curriculumVitae, requestLanguage.languageName());
    }

    public void update(Long id, CurriculumVitae curriculumVitae){
        curriculumVitaeUpdate.update(curriculumVitaeReader.getCurriculumVitae(id), curriculumVitae);
    }

    public void delete(Long id){
        curriculumVitaeDeleter.delete(id);
    }
}
