package com.repoo.enterprise.service.implementation;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.enterprise.domain.repository.EnterpriseRepository;
import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseCreator {

    private final EnterpriseRepository enterpriseRepository;

    public void save(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

}
