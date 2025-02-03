package com.repoo.global.jwt.dto;

public record LoginRequest(
        String enterpriseAuthId,
        String password
) {}
