package com.repoo.enterprise.service.implementation;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.enterprise.domain.repository.EnterpriseRepository;
import com.repoo.jobpost.domain.JobPost;
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
