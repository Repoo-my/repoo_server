package com.repoo.domain.authentication.auth.presentation;

import com.repoo.domain.authentication.auth.presentation.dto.request.AdditionalInfoRequest;
import com.repoo.domain.authentication.auth.service.implementation.AdditionalInfoUpdater;
import com.repoo.domain.authentication.auth.service.implementation.ReIssuer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.repoo.global.jwt.util.AuthenticationUtil.getMemberId;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final ReIssuer reIssuer;
    private final AdditionalInfoUpdater additionalInfoUpdater;

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "토큰 재발급", description = "JWT 토큰을 재발급합니다.")
    public void reissue(
        @Parameter(description = "HTTP 요청") HttpServletRequest request,
        @Parameter(description = "HTTP 응답") HttpServletResponse response
    ) {
        reIssuer.reissue(request, response);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "추가 정보", description = "소셜로그인 후 추가 정보를 받아야 합니다.")
    public void updateAdditionalInfo(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody AdditionalInfoRequest additionalInfoRequest
    ) throws IOException {
        additionalInfoUpdater.update(request, response, getMemberId(), additionalInfoRequest);
    }


    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "인가 여부", description = "현재 유저의 인가 가능 여부를 판별합니다.")
    public void checkAuthStatus() {
        log.warn("AuthController : /check 성공");
    }

}
