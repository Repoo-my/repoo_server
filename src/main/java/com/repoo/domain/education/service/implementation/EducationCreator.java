package com.repoo.domain.education.service.implementation;

import com.repoo.domain.education.domain.Education;
import com.repoo.domain.education.domain.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationCreator {

    private final EducationRepository educationRepository;

    public void save(Education education) {
        educationRepository.save(education);
    }
}
