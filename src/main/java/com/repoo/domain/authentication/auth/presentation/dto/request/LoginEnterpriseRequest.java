package com.repoo.domain.authentication.auth.presentation.dto.request;

public record LoginEnterpriseRequest(
        String enterpriseName,
        String password
) {
}
