package com.repoo.career.service.imlementation;

import com.repoo.career.domain.Career;
import com.repoo.career.domain.repository.CareerRepository;
import com.repoo.career.exception.CareerNotFoundException;
import com.repoo.curriculumvitae.domain.CurriculumVitae;
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
