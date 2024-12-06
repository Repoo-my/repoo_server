package com.repoo.enterprise.service.implementation;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.enterprise.domain.repository.EnterpriseRepository;
import com.repoo.enterprise.exception.EnterpriseNotFoundException;
import com.repoo.jobpost.domain.JobPost;
import com.repoo.jobpost.domain.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnterpriseReader {

    private final EnterpriseRepository enterpriseRepository;

    public Enterprise findById(Long id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(EnterpriseNotFoundException::new);
    }

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }
}
