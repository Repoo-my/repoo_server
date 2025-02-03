package com.repoo.domain.authentication.auth.service.implementation;

import com.repoo.domain.authentication.auth.presentation.dto.request.JoinEnterpriseRequest;
import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.enterprise.domain.repository.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnterpriseJoiner {

    private final EnterpriseRepository enterpriseRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void join(JoinEnterpriseRequest joinEnterpriseRequest) {

        Enterprise enterprise = new Enterprise(
                joinEnterpriseRequest.enterpriseAuthId(),
                joinEnterpriseRequest.enterpriseName(),
                passwordEncoder.encode(joinEnterpriseRequest.enterprisePassword()),
                joinEnterpriseRequest.enterpriseDescription(),
                joinEnterpriseRequest.enterpriseEmail(),
                joinEnterpriseRequest.enterprisePhone(),
                joinEnterpriseRequest.enterpriseTags()
        );

        enterpriseRepository.save(enterprise);
    }

}
