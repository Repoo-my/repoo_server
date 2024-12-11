package com.repoo.education.service.implementation;

import com.repoo.education.domain.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationDeleter {

    private final EducationRepository educationRepository;

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }
}
