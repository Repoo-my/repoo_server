package com.repoo.domain.main.enterprise.presentation.dto.req;

public record RequestEnterprise(
        String enterpriseName,
        String enterprisePassword,
        String enterpriseDescription,
        String enterpriseEmail,
        String enterprisePhone,
        String[] enterpriseTags
) {
}
