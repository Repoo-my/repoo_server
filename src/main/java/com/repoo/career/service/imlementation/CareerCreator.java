package com.repoo.career.service.imlementation;

import com.repoo.career.domain.Career;
import com.repoo.career.domain.repository.CareerRepository;
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
