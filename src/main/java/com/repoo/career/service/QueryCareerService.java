package com.repoo.career.service;

import com.repoo.career.domain.Career;
import com.repoo.career.service.imlementation.CareerReader;
import com.repoo.curriculumvitae.service.implementation.CurriculumVitaeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<Career> getCareerByCurriculumVitae(Long curriculumVitaeId){
        return careerReader.getCareersByCurriculumVitae(
                curriculumVitaeReader.getCurriculumVitae(curriculumVitaeId)
        );
    }
}
