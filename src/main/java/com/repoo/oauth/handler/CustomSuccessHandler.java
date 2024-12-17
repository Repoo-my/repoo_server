package com.repoo.oauth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repoo.global.jwt.util.JwtUtil;
import com.repoo.oauth.service.dto.CustomOAuth2User;
import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import com.repoo.user.domain.value.Authority;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final UsersRepository userRepository;

    @Value("${server.redirect}")
    private String redirectUrl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.warn("오어스 성공 핸들러 authentication : "+authentication);
        CustomOAuth2User customUserDetails = (CustomOAuth2User) authentication.getPrincipal();
        log.warn("오어스 성공 핸들러" + customUserDetails.toString());

        Long id = customUserDetails.getId();

        Authority role = customUserDetails.getAuthorities().stream()
                .findFirst()
                .map(a -> Authority.fromValue(a.getAuthority()))
                .orElse(Authority.USER);

        Users user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        boolean isNewUser = user == null || user.getUserAge() == null;
        log.warn("오어스 성공 핸들러 중간 체크 : "+isNewUser);

        if (isNewUser) {
            role = Authority.USER;
            if (user != null) {
                user.updateRole(role);
                userRepository.save(user);
            }
        }

        String accessToken = jwtUtil.createAccessToken(id, role, "social");
        String refreshToken = jwtUtil.createRefreshToken(id, role, "social");

        jwtUtil.addRefreshToken(id, refreshToken);

        log.warn("소셜 로그인 필터 동작");

        // JSON 데이터를 헤더로 보내기
        Map<String, Object> responseHeader = new HashMap<>();
        responseHeader.put("accessToken", accessToken);
        responseHeader.put("refreshToken", refreshToken);

        // JSON 직렬화
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(responseHeader);

        // 응답 헤더 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setStatus(HttpServletResponse.SC_OK); // 성공 상태 코드

        // JSON 데이터를 헤더에 추가
        response.setHeader("Response-Data", jsonString);

        if (isNewUser) {
            log.warn("오어스 성공 핸들러 새로운 유저");
            response.sendRedirect(redirectUrl+"/users");
        } else {
            log.warn("오어스 성공 핸들러 원래 있던 유저");
            response.sendRedirect(redirectUrl);
        }
    }
}
