package com.repoo.domain.auth.service;

import com.repoo.domain.auth.domain.RefreshToken;
import com.repoo.domain.auth.domain.repository.RefreshTokenRepository;
import com.repoo.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.repoo.global.exception.security.ExpiredPeriodToken;
import com.repoo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccessTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return new AccessTokenResponse(jwtTokenProvider
                .createAccessToken(refreshToken.getEmail()));
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(ExpiredPeriodToken::new);
    }
}