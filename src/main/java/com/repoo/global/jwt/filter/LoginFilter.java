package com.repoo.global.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repoo.domain.authentication.auth.exception.AuthUserNotFoundException;
import com.repoo.domain.authentication.auth.exception.InvalidCredentialsException;
import com.repoo.domain.authentication.auth.service.dto.CustomEnterpriseDetails;
import com.repoo.domain.authentication.auth.service.dto.CustomUserDetails;
import com.repoo.global.jwt.dto.LoginRequest;
import com.repoo.global.jwt.util.JwtUtil;
import com.repoo.domain.main.user.domain.value.Authority;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ObjectMapper objectMapper;

    public LoginFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, ObjectMapper objectMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.objectMapper = objectMapper;
        setUsernameParameter("enterpriseAuthId");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            LoginRequest loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);

            String enterpriseAuthId = loginRequest.enterpriseAuthId();
            String password = loginRequest.password();

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(enterpriseAuthId, password);

            return authenticationManager.authenticate(authRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication){

        CustomEnterpriseDetails customEnterpriseDetails = (CustomEnterpriseDetails) authentication.getPrincipal();

        Long id = customEnterpriseDetails.getId();

        String accessToken = jwtUtil.createAccessToken(id, Authority.ENTERPRISE, "normal");
        String refreshToken = jwtUtil.createRefreshToken(id, Authority.ENTERPRISE, "normal");


        jwtUtil.addRefreshToken(id, refreshToken);
        log.warn("자체 로그인 필터 동작");
        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createAccessCookie("access_normal", accessToken).toString());
        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createRefreshCookie("refresh_normal", refreshToken).toString());
        response.setStatus(HttpStatus.OK.value());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed){

        log.warn("로그인 실패 로그 : "+failed.getMessage());
        if (failed.getMessage().contains("자격 증명에 실패하였습니다.")) {
            throw new InvalidCredentialsException();
        } else if (failed.getMessage().contains("UserDetailsService returned null")) {
            throw new AuthUserNotFoundException();
        } else {
            response.setStatus(401);
        }

    }

}
