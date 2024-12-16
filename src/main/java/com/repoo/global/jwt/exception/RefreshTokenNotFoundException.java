package com.repoo.global.jwt.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class RefreshTokenNotFoundException extends RepooException {

    public RefreshTokenNotFoundException() {
        super(HttpStatus.UNAUTHORIZED, "REFRESH_TOKEN_NOT_FOUND", "리프레시 토큰이 존재하지 않습니다.");
    }
}
