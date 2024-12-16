package com.repoo.global.jwt.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends RepooException {

    public ExpiredTokenException() {
        super(HttpStatus.UNAUTHORIZED, "EXPIRED_TOKEN", "만료된 토큰입니다.");
    }
}
