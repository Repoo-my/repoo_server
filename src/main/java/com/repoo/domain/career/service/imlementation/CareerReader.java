package com.repoo.domain.career.service.imlementation;

import com.repoo.domain.career.domain.Career;
import com.repoo.domain.career.domain.repository.CareerRepository;
import com.repoo.domain.career.exception.CareerNotFoundException;
import com.repoo.domain.curriculumvitae.domain.CurriculumVitae;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerReader {

    private final CareerRepository careerRepository;

    public Career getCareer(Long id){
        return careerRepository.findById(id)
                .orElseThrow(CareerNotFoundException::new);
    }

    public List<Career> getCareers(){
        return careerRepository.findAll();
    }

    public List<Career> getCareersByCurriculumVitae(CurriculumVitae curriculumVitae){
        return careerRepository.findAllByCurriculumVitae(curriculumVitae);
    }
}
