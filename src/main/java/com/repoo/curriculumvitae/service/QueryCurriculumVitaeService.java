package com.repoo.curriculumvitae.service;

import com.repoo.career.service.QueryCareerService;
import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.curriculumvitae.presentation.dto.response.*;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import com.repoo.education.service.QueryEducationService;
import com.repoo.language.service.QueryLanguageService;
import com.repoo.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCurriculumVitaeService {

    private final QueryCareerService queryCareerService;
    private final QueryEducationService queryEducationService;
    private final QueryLanguageService queryLanguageService;

    private final CurriculumVitaeReader curriculumVitaeReader;
    private final UsersReader usersReader;

    public ResponseDetailCurriculumVitae getCurriculumVitae(Long userId, Long curriculumVitaeId){
        CurriculumVitae curriculumVitae = curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId);
        List<ResponseCareer> responseCareer = queryCareerService.getCareerByCurriculumVitae(curriculumVitaeId);
        List<ResponseEducation> responseEducations = queryEducationService.getEducationsByCurriculumVitae(curriculumVitaeId);
        List<ResponseLanguage> responseLanguages = queryLanguageService.getLanguagesByCurriculumVitae(curriculumVitaeId);


        return new ResponseDetailCurriculumVitae(
                usersReader.findById(userId).getUserName(),
                curriculumVitae.getCurriculumVitaeTitle(),
                curriculumVitae.getCurriculumVitaeIntroduction(),
                curriculumVitae.getCurriculumVitaeAddress(),
                LocalDate.now(),
                responseCareer,
                responseEducations,
                responseLanguages
        );
    }

    public List<ResponseCurriculumVitae> getCurriculumVitaesByUser(Long userId){
        List<CurriculumVitae> curriculumVitaes = curriculumVitaeReader.getCurriculumVitaesByUser(usersReader.findById(userId));

        List<ResponseCurriculumVitae> responseCurriculumVitaes = new java.util.ArrayList<>(List.of());
        for (CurriculumVitae curriculumVitae : curriculumVitaes) {
            responseCurriculumVitaes.add(new ResponseCurriculumVitae(
                    curriculumVitae.getCurriculumVitaeTitle(),
                    curriculumVitae.getCurriculumVitaeIntroduction(),
                    curriculumVitae.getCurriculumVitaeUpdateDate()
            ));
        }

        return responseCurriculumVitaes;
    }
}
