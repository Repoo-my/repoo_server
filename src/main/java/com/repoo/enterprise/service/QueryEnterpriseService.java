package com.repoo.enterprise.service;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.enterprise.service.implementation.EnterpriseReader;
import com.repoo.jobpost.domain.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryEnterpriseService {

    private final EnterpriseReader enterpriseReader;

    public List<Enterprise> getAllEnterprise() {
        return enterpriseReader.findAll();
    }

    public Enterprise getEnterpriseById(Long id) {
        return enterpriseReader.findById(id);
    }
}
