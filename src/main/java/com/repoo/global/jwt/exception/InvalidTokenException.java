package com.repoo.global.jwt.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends RepooException {

    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "INVALID_TOKEN", "잘못된 토큰입니다.");
    }
}
