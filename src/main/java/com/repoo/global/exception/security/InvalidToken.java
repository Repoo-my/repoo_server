package com.repoo.global.exception.security;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class InvalidToken extends RepooException {
    public InvalidToken() {
        super(HttpStatus.NOT_FOUND, "INVALID_TOKEN", "올바르지 않은 형식의 토큰입니다.");
    }
}
