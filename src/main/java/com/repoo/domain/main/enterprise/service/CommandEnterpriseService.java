package com.repoo.domain.main.enterprise.service;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.presentation.dto.req.RequestEnterprise;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseCreator;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseDeleter;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseReader;
import com.repoo.domain.main.enterprise.service.implementation.EnterpriseUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CommandEnterpriseService {

    private final EnterpriseCreator enterpriseCreator;
    private final EnterpriseUpdater enterpriseUpdater;
    private final EnterpriseDeleter enterpriseDeleter;
    private final EnterpriseReader enterpriseReader;

    public void create(RequestEnterprise enterprise) {
        enterpriseCreator.save(new Enterprise(
                enterprise.enterpriseName(),
                enterprise.enterprisePassword(),
                enterprise.enterpriseDescription(),
                enterprise.enterpriseEmail(),
                enterprise.enterprisePhone(),
                enterprise.enterpriseTags()
        ));
    }

    public void update(Long enterpriseId, RequestEnterprise enterprise) {
        enterpriseUpdater.update(
                enterpriseReader.findById(enterpriseId),
                new Enterprise(
                        enterprise.enterpriseName(),
                        enterprise.enterprisePassword(),
                        enterprise.enterpriseDescription(),
                        enterprise.enterpriseEmail(),
                        enterprise.enterprisePhone(),
                        enterprise.enterpriseTags()
                )
        );
    }

    public void delete(Long enterpriseId) {
        enterpriseDeleter.delete(enterpriseReader.findById(enterpriseId));
    }

}
