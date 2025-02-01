package com.repoo.domain.main.enterprise.service.implementation;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.domain.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnterpriseUpdater {

    private final EnterpriseRepository enterpriseRepository;

    public void update(Enterprise updatableEnterprise, Enterprise enterprise) {
        updatableEnterprise.update(
                enterprise.getEnterpriseName(),
                enterprise.getEnterprisePassword(),
                enterprise.getEnterpriseDescription(),
                enterprise.getEnterprisePhone(),
                enterprise.getEnterpriseEmail(),
                enterprise.getEnterpriseTags()
        );

        enterpriseRepository.save(updatableEnterprise);
    }
}
