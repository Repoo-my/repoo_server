package com.repoo.domain.enterprise.service.implementation;

import com.repoo.domain.enterprise.domain.Enterprise;
import com.repoo.domain.enterprise.domain.repository.EnterpriseRepository;
import com.repoo.domain.enterprise.exception.EnterpriseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseReader {

    private final EnterpriseRepository enterpriseRepository;

    public Enterprise findById(Long id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(EnterpriseNotFoundException::new);
    }

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }
}
