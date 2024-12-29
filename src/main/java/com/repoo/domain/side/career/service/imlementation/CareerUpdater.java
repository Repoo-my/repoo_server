package com.repoo.domain.side.career.service.imlementation;

import com.repoo.domain.side.career.domain.Career;
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
