package com.repoo.auth.service.implementation;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdditionalInfoUpdater {

    private final UsersRepository userRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void update(HttpServletRequest request, HttpServletResponse response, Long userId, AdditionalInfoRequest additionalInfoRequest) {
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

        String newAccess = jwtUtil.createAccessToken(id, role, loginType);
        String newRefresh = jwtUtil.createRefreshToken(id, role, loginType);

        refreshTokenRepository.deleteByRefreshToken(refresh);
        jwtUtil.addRefreshToken(id, newRefresh);

        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createAccessCookie(accessCookieName, newAccess).toString());
        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createRefreshCookie(refreshCookieName, newRefresh).toString());

    }
}
