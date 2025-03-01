package com.repoo.domain.authentication.auth.presentation;

import com.repoo.domain.authentication.auth.presentation.dto.request.AdditionalInfoRequest;
import com.repoo.domain.authentication.auth.presentation.dto.request.JoinEnterpriseRequest;
import com.repoo.domain.authentication.auth.service.implementation.AdditionalInfoUpdater;
import com.repoo.domain.authentication.auth.service.implementation.EnterpriseJoiner;
import com.repoo.domain.authentication.auth.service.implementation.ReIssuer;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final ReIssuer reIssuer;
    private final AdditionalInfoUpdater additionalInfoUpdater;
    private final JWTPayloadDecoder jWTPayloadDecoder;
    private final EnterpriseJoiner enterpriseJoiner;

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "토큰 재발급", description = "JWT 토큰을 재발급합니다.")
    public void reissue(
        @Parameter(description = "HTTP 응답") HttpServletResponse response,
        @RequestHeader String refreshToken
    ) throws IOException {
        reIssuer.reissue(refreshToken, response);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "추가 정보", description = "소셜로그인 후 추가 정보를 받아야 합니다. access token과 refresh 토큰을 재발급합니다.")
    public void updateAdditionalInfo(
            HttpServletResponse response,
            @RequestHeader String accessToken,
            @RequestHeader String refreshToken,
            @RequestBody AdditionalInfoRequest additionalInfoRequest
    ) throws IOException {
        additionalInfoUpdater.update(
                refreshToken,
                response,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                additionalInfoRequest
        );
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "인가 여부", description = "현재 유저의 인가 가능 여부를 판별합니다.")
    public void checkAuthStatus() {
        log.warn("AuthController : /check 성공");
    }

    @PostMapping("/enterprise/join")
    public void enterpriseJoin(
            @RequestBody JoinEnterpriseRequest joinEnterpriseRequest
    ){
        enterpriseJoiner.join(joinEnterpriseRequest);
    }

}
