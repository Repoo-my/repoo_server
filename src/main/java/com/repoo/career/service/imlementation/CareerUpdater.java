package com.repoo.career.service.imlementation;

import com.repoo.career.domain.Career;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerUpdater {

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
    }
}
