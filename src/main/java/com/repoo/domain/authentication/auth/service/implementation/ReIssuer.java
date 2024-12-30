package com.repoo.domain.authentication.auth.service.implementation;

import com.repoo.domain.authentication.auth.domain.repository.RefreshTokenRepository;
import com.repoo.global.jwt.exception.InvalidTokenException;
import com.repoo.global.jwt.exception.RefreshTokenNotFoundException;
import com.repoo.global.jwt.util.JwtUtil;
import com.repoo.domain.main.user.domain.value.Authority;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReIssuer {

    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshRepository;

    @Value("${server.redirect}")
    private String redirectUrl;

    public void reissue(String refresh, HttpServletResponse response) throws IOException {

        if (refresh == null) {
            log.warn("Refresh token not found in cookies");
            throw new RefreshTokenNotFoundException();
        }

        jwtUtil.isExpiredRefresh(refresh, response);

        String category = jwtUtil.getCategory(refresh);

        if (!category.equals("refresh")) {
            log.warn("Invalid token category: {}", category);
            throw new InvalidTokenException();
        }

        Boolean isExist = refreshRepository.existsByRefreshToken(refresh);

        if (!isExist) {
            log.warn("Refresh token not found in database: {}", refresh);
            throw new RefreshTokenNotFoundException();
        }

        String loginType = jwtUtil.getLoginType(refresh);
        String accessCookieName = "access_" + loginType;
        String refreshCookieName = "refresh_" + loginType;

        Long id = jwtUtil.getId(refresh);
        Authority role = jwtUtil.getAuthority(refresh);

        String newAccess = jwtUtil.createAccessToken(id, role, loginType);
        String newRefresh = jwtUtil.createRefreshToken(id, role, loginType);

        refreshRepository.deleteByRefreshToken(refresh);
        jwtUtil.addRefreshToken(id, newRefresh);

        String queryParam = String.format(
                "?accessToken=%s&refreshToken=%s",
                URLEncoder.encode(newAccess, StandardCharsets.UTF_8.name()),
                URLEncoder.encode(newRefresh, StandardCharsets.UTF_8.name())
        );

        // 응답 헤더 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(HttpServletResponse.SC_OK); // 성공 상태 코드

        response.sendRedirect(redirectUrl+queryParam);
    }

}
