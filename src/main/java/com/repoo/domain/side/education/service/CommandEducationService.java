package com.repoo.domain.side.education.service;

import com.repoo.domain.side.education.domain.Education;
import com.repoo.domain.side.education.service.implementation.EducationCreator;
import com.repoo.domain.side.education.service.implementation.EducationDeleter;
import com.repoo.domain.side.education.service.implementation.EducationReader;
import com.repoo.domain.side.education.service.implementation.EducationUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandEducationService {

    private final EducationCreator educationCreator;
    private final EducationDeleter educationDeleter;
    private final EducationUpdater educationUpdater;
    private final EducationReader educationReader;

    public void save(Education education){
        educationCreator.save(education);
    }

    public void update(Long id, Education education){
        educationUpdater.update(educationReader.getEducation(id), education);
    }

    public void delete(Long id){
        educationDeleter.delete(id);
    }
}
