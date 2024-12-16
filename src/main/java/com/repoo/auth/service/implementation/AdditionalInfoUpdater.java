package com.repoo.auth.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repoo.auth.domain.repository.RefreshTokenRepository;
import com.repoo.auth.presentation.dto.request.AdditionalInfoRequest;
import com.repoo.global.jwt.exception.InvalidTokenException;
import com.repoo.global.jwt.exception.RefreshTokenNotFoundException;
import com.repoo.global.jwt.util.JwtUtil;
import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import com.repoo.user.domain.value.Authority;
import com.repoo.user.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdditionalInfoUpdater {

    private final UsersRepository userRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void update(HttpServletRequest request, HttpServletResponse response, Long userId, AdditionalInfoRequest additionalInfoRequest) throws IOException {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

        String refresh = jwtUtil.getTokenFromCookies(request, "refresh_social");

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

        Boolean isExist = refreshTokenRepository.existsByRefreshToken(refresh);

        if (!isExist) {
            log.warn("Refresh token not found in database: {}", refresh);
            throw new RefreshTokenNotFoundException();
        }

        user.updateAdditionalInfo(additionalInfoRequest.userName(), additionalInfoRequest.userGender(), additionalInfoRequest.userAge(), additionalInfoRequest.userPhone());
        user.updateRole(Authority.USER);

        String loginType = jwtUtil.getLoginType(refresh);
        String accessCookieName = "access_" + loginType;
        String refreshCookieName = "refresh_" + loginType;

        Long id = jwtUtil.getId(refresh);
        Authority role = Authority.USER;

        String newAccessToken = jwtUtil.createAccessToken(id, role, loginType);
        String newRefreshToken = jwtUtil.createRefreshToken(id, role, loginType);

        refreshTokenRepository.deleteByRefreshToken(refresh);
        jwtUtil.addRefreshToken(id, newRefreshToken);

        // JSON 응답 생성
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("accessToken", newAccessToken);
        responseBody.put("refreshToken", newRefreshToken);

        // 응답 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(HttpServletResponse.SC_OK); // 성공 상태 코드

        // JSON 데이터를 바디에 쓰기
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(responseBody));
    }
}
