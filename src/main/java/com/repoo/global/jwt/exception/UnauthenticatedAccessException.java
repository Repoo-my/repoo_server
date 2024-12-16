package com.repoo.global.jwt.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class UnauthenticatedAccessException extends RepooException {
    public UnauthenticatedAccessException() {
        super(HttpStatus.UNAUTHORIZED, "UNAUTHENTICATED_ACCESS", "인증이 필요합니다.");
    }
}
