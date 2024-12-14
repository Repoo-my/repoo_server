package com.repoo.domain.enterprise.service.implementation;

import com.repoo.domain.enterprise.domain.Enterprise;
import com.repoo.domain.enterprise.domain.repository.EnterpriseRepository;
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
