package com.repoo.auth.service;

import com.repoo.auth.presentation.dto.response.TokenResponse;
import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import com.repoo.user.domain.type.Authority;
import com.repoo.global.feign.GoogleInformationClient;
import com.repoo.global.feign.response.GoogleInformationResponse;
import com.repoo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {
    private final GoogleInformationClient googleInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersRepository userRepository;

    @Transactional
    public TokenResponse execute(String accessToken) {
        GoogleInformationResponse response = googleInformationClient
                .getUserInformation(accessToken);
        String email = response.getEmail();
        Optional<Users> user = userRepository.findByUserEmail(email);

        if (user.isEmpty()) {
            userRepository.save(
                    new Users(email, Authority.USER));
        }

        return new TokenResponse(
                jwtTokenProvider.createAccessToken(email),
                jwtTokenProvider.createRefreshToken(email)
        );
    }
}