package com.repoo.domain.side.career.service;

import com.repoo.domain.side.career.domain.Career;
import com.repoo.domain.side.career.service.imlementation.CareerReader;
import com.repoo.domain.main.curriculumvitae.presentation.dto.response.ResponseCareer;
import com.repoo.domain.main.curriculumvitae.service.implementation.CurriculumVitaeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCareerService {

    private final CareerReader careerReader;
    private final CurriculumVitaeReader curriculumVitaeReader;

    public Career getCareer(Long id){
        return careerReader.getCareer(id);
    }

    public List<Career> getCareers(){
        return careerReader.getCareers();
    }

    public List<ResponseCareer> getCareerByCurriculumVitae(Long curriculumVitaeId){
        List<Career> careers = careerReader.getCareersByCurriculumVitae(curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId));

        List<ResponseCareer> responseCareers = new ArrayList<>();
        for (Career career : careers) {
            responseCareers.add(new ResponseCareer(
                    career.getCareerName(),
                    career.getCareerType(),
                    career.getCareerDepartment(),
                    career.getCareerPosition(),
                    career.getCareerStartDate(),
                    career.getCareerEndDate(),
                    career.getRetirementDescription(),
                    career.getCareerDescription()
            ));
        }

        return responseCareers;
    }
}
