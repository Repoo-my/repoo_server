package com.repoo.domain.side.career.service.imlementation;

import com.repoo.domain.side.career.domain.Career;
import com.repoo.domain.side.career.domain.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerUpdater {

    private final CareerRepository careerRepository;

    public void update(Career updatableCareer, Career career){
        updatableCareer.update(
                career.getCareerName(),
                career.getCareerType(),
                career.getCareerDepartment(),
                career.getCareerPosition(),
                career.getCareerStartDate(),
                career.getCareerEndDate(),
                career.getRetirementDescription(),
                career.getCareerDescription()
        );

        careerRepository.save(updatableCareer);
    }
}
