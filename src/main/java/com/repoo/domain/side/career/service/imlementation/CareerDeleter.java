package com.repoo.domain.side.career.service.imlementation;

import com.repoo.domain.side.career.domain.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerDeleter {

    private final CareerRepository careerRepository;

    public void delete(Long id){
        careerRepository.deleteById(id);
    }
}
