package com.repoo.auth.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefreshTokenRequest {
    @NotNull(message = "refreshToken이 비어있습니다.")
    private String refreshToken;
}