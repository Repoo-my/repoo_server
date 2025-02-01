package com.repoo.domain.main.enterprise.service;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.presentation.dto.res.ResponseEnterprise;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryEnterpriseService {

    private final EnterpriseReader enterpriseReader;

    public List<ResponseEnterprise> getAllEnterprise() {
        List<Enterprise> enterprises = enterpriseReader.findAll();
        List<ResponseEnterprise> responseEnterprises = new ArrayList<>();

        for (Enterprise enterprise: enterprises) {
            responseEnterprises.add(new ResponseEnterprise(
                    enterprise.getEnterpriseName(),
                    enterprise.getEnterpriseDescription(),
                    enterprise.getEnterpriseEmail(),
                    enterprise.getEnterprisePhone(),
                    enterprise.getEnterpriseTags()
            ));
        }

        return responseEnterprises;
    }

    public ResponseEnterprise getEnterpriseById(Long id) {
        Enterprise enterprise = enterpriseReader.findById(id);

        return new ResponseEnterprise(
                enterprise.getEnterpriseName(),
                enterprise.getEnterpriseDescription(),
                enterprise.getEnterpriseEmail(),
                enterprise.getEnterprisePhone(),
                enterprise.getEnterpriseTags()
        );
    }
}
