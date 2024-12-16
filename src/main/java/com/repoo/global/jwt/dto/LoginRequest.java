package com.repoo.global.jwt.dto;

public record LoginRequest(
        String email,
        String password
) {}
