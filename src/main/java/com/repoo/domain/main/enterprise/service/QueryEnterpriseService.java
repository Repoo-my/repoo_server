package com.repoo.domain.main.enterprise.service;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
