package com.repoo.enterprise.service.implementation;

import com.repoo.enterprise.domain.Enterprise;
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
