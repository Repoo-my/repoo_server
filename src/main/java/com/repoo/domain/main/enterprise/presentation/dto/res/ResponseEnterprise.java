package com.repoo.domain.main.enterprise.presentation.dto.res;

public record ResponseEnterprise(
        String enterpriseName,
        String enterpriseDescription,
        String enterpriseEmail,
        String enterprisePhone,
        String[] enterpriseTags
) {
}
