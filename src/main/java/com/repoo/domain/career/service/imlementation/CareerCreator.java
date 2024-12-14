package com.repoo.domain.career.service.imlementation;

import com.repoo.domain.career.domain.Career;
import com.repoo.domain.career.domain.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerCreator {

    private final CareerRepository careerRepository;

    public void save(Career career){
        careerRepository.save(career);
    }

}
