package com.repoo.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessTokenRequest {
    @NotNull(message = "accessToken이 비어있습니다.")
    private String accessToken;
}