package com.repoo.domain.enterprise.service.implementation;

import com.repoo.domain.enterprise.domain.Enterprise;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnterpriseUpdater {

    public void update(Enterprise updatableEnterprise, Optional<Enterprise> enterprise) {
        updatableEnterprise.update(
                enterprise.get().getEnterpriseName()
        );
    }
}
