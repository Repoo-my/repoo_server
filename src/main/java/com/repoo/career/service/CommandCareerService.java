package com.repoo.career.service;

import com.repoo.career.domain.Career;
import com.repoo.career.service.imlementation.CareerCreator;
import com.repoo.career.service.imlementation.CareerDeleter;
import com.repoo.career.service.imlementation.CareerReader;
import com.repoo.career.service.imlementation.CareerUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandCareerService {

    private final CareerCreator careerCreator;
    private final CareerDeleter careerDeleter;
    private final CareerUpdater careerUpdater;
    private final CareerReader careerReader;

    public void save(Career career){
        careerCreator.save(career);
    }

    public void update(Long id, Career career){
        careerUpdater.update(careerReader.getCareer(id), career);
    }

    public void delete(Long id){
        careerDeleter.delete(id);
    }

}
