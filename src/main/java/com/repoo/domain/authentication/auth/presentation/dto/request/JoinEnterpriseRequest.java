package com.repoo.domain.authentication.auth.presentation.dto.request;

public record JoinEnterpriseRequest(
        String enterpriseAuthId,
        String enterpriseName,
        String enterprisePassword,
        String enterpriseDescription,
        String enterpriseEmail,
        String enterprisePhone,
        String[] enterpriseTags
) {
}
