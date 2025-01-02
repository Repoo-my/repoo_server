package com.repoo.domain.authentication.oauth.service.dto;

import com.repoo.domain.main.user.domain.value.Authority;
import lombok.Builder;

public record UserDto(
        Authority role,
        Long id,
        String oauthType,
        String oauthAccessToken,
        String oauthRefreshToken
) {

    @Builder
    public UserDto(Authority role, Long id, String userEmail, String oauthType, String oauthAccessToken, String oauthRefreshToken) {
        this.role = role;
        this.id = id;
        this.oauthType = oauthType;
        this.oauthAccessToken = oauthAccessToken;
        this.oauthRefreshToken = oauthRefreshToken;
    }

}
