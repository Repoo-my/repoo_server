package com.repoo.domain.main.enterprise.service.implementation;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.domain.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseDeleter {

    private final EnterpriseRepository enterpriseRepository;

    public void delete(Enterprise enterprise) {
        enterpriseRepository.delete(enterprise);
    }
}
