package com.repoo.education.service.implementation;

import com.repoo.education.domain.Education;
import com.repoo.education.domain.repository.EducationRepository;
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
