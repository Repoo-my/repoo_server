package com.repoo.auth.service;

import com.repoo.auth.domain.repository.RefreshTokenRepository;
import com.repoo.auth.presentation.dto.request.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute(RefreshTokenRequest request) {
        refreshTokenRepository.deleteById(request.getRefreshToken());
    }
}