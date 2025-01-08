package com.repoo.domain.main.curriculumvitae.service;

import com.repoo.domain.main.curriculumvitae.exception.CurriculumVitaeNotFoundException;
import com.repoo.domain.main.user.service.QueryUsersService;
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
import com.repoo.domain.side.career.service.imlementation.CareerDeleter;
import com.repoo.domain.side.career.service.imlementation.CareerReader;
import com.repoo.domain.side.career.service.imlementation.CareerUpdater;
import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.service.CommandEducationService;
import com.repoo.domain.side.education.service.implementation.EducationReader;
import com.repoo.domain.side.education.service.implementation.EducationUpdater;
import com.repoo.domain.side.language.domain.Language;
import com.repoo.domain.side.language.service.CommandLanguageService;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import com.repoo.domain.side.language.service.implementation.LanguageReader;
import com.repoo.domain.side.language.service.implementation.LanguageUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;

@Slf4j
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
    private final QueryUsersService queryUsersService;
    private final EducationUpdater educationUpdater;
    private final EducationReader educationReader;
    private final CareerReader careerReader;
    private final LanguageReader languageReader;
    private final CareerUpdater careerUpdater;
    private final LanguageUpdater languageUpdater;

    public void save(
            Long userId,
            RequestCurriculumVitae requestCurriculumVitae
    ){
        List<RequestEducation> requestEducations = requestCurriculumVitae.requestEducations();
        List<RequestCareer> requestCareers = requestCurriculumVitae.requestCareers();
        List<RequestLanguage> requestLanguages = requestCurriculumVitae.requestLanguages();

        CurriculumVitae curriculumVitae = new CurriculumVitae(
                queryUsersService.getUser(userId),
                requestCurriculumVitae.curriculumVitaeTitle(),
                requestCurriculumVitae.curriculumVitaeIntroduction(),
                requestCurriculumVitae.curriculumVitaeAddress(),
                LocalDate.now(ZoneId.of("Asia/Seoul"))
        );
        curriculumVitaeCreator.save(curriculumVitae);

        if(!requestCareers.isEmpty()){
            for (RequestCareer career: requestCareers){
                commandCareerService.save(new Career(
                        curriculumVitae,
                        career.careerName(),
                        career.careerType(),
                        career.careerDepartment(),
                        career.careerPosition(),
                        career.careerStartDate(),
                        career.careerEndDate(),
                        career.retirementDescription(),
                        career.careerDescription()
                ));
            }
        }

        if(!requestEducations.isEmpty()) {
            for (RequestEducation education : requestEducations) {
                commandEducationService.save(new Education(
                        curriculumVitae,
                        education.schoolName(),
                        education.departmentName(),
                        education.admission_day(),
                        education.graduation_day()
                ));
            }
        }

        if(!requestLanguages.isEmpty()) {
            for (RequestLanguage language : requestLanguages) {
                commandLanguageService.save(curriculumVitae, language.languageName());
            }
        }
    }

    public void update(Long id,
                       Long userId,
                       RequestCurriculumVitae requestCurriculumVitae
    ){
        log.warn("curriculumVitae : " + requestCurriculumVitae.toString());
        log.warn("curriculumVitae : " + requestCurriculumVitae.requestCareers().toString());
        log.warn("curriculumVitae : " + requestCurriculumVitae.requestEducations().toString());
        log.warn("curriculumVitae : " + requestCurriculumVitae.requestLanguages().toString());

        CurriculumVitae curriculumVitae = curriculumVitaeReader.getCurriculumVitae(id);

        curriculumVitaeUpdate.update(
                curriculumVitae,
                new CurriculumVitae(
                        queryUsersService.getUser(userId),
                        requestCurriculumVitae.curriculumVitaeTitle(),
                        requestCurriculumVitae.curriculumVitaeIntroduction(),
                        requestCurriculumVitae.curriculumVitaeAddress(),
                        LocalDate.now(ZoneId.of("Asia/Seoul"))
                )
        );

        if(!requestCurriculumVitae.requestEducations().isEmpty()) {
            for (Education education : educationReader.getEducationsByCurriculumVitae(curriculumVitae)) {
                for (RequestEducation requestEducation : requestCurriculumVitae.requestEducations()) {
                    educationUpdater.update(
                            education,
                            new Education(
                                    curriculumVitae,
                                    requestEducation.schoolName(),
                                    requestEducation.departmentName(),
                                    requestEducation.admission_day(),
                                    requestEducation.graduation_day()
                            )
                    );
                }
            }
        }

        if(!requestCurriculumVitae.requestCareers().isEmpty()) {
            for (Career career : careerReader.getCareersByCurriculumVitae(curriculumVitae)) {
                for (RequestCareer requestCareer : requestCurriculumVitae.requestCareers()) {
                    careerUpdater.update(career, new Career(
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
                }
            }
        }

        if(!requestCurriculumVitae.requestLanguages().isEmpty()) {
            for (Language language : languageReader.findByCurriculumVitae(curriculumVitae)) {
                for (RequestLanguage requestLanguage : requestCurriculumVitae.requestLanguages()) {
                    languageUpdater.update(
                            language,
                            new Language(
                                    curriculumVitae,
                                    requestLanguage.languageName()
                            )
                    );
                }
            }
        }


    }

    public void delete(Long id, Long userId){
        CurriculumVitae curriculumVitae = curriculumVitaeReader.getCurriculumVitae(id);

        if (userId.equals(curriculumVitae.getUser().getUsersId())){
            for (Education education: educationReader.getEducationsByCurriculumVitae(curriculumVitae)){
                commandEducationService.delete(education.getEducationId());
            }

            for (Career career: careerReader.getCareersByCurriculumVitae(curriculumVitae)){
                commandCareerService.delete(career.getCareerId());
            }

            for (Language language: languageReader.findByCurriculumVitae(curriculumVitae)){
                commandLanguageService.delete(language.getLanguageId());
            }

            curriculumVitaeDeleter.delete(id);
        } else {
            throw new CurriculumVitaeNotFoundException();
        }
    }
}
