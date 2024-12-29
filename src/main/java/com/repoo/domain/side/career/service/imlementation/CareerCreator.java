package com.repoo.domain.side.career.service.imlementation;

import com.repoo.domain.side.career.domain.Career;
import com.repoo.domain.side.career.domain.repository.CareerRepository;
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
