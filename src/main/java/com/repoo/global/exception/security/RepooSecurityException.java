package com.repoo.global.exception.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class RepooSecurityException extends AuthenticationException {
    private final HttpStatus status;
    private final String errorCode;

    public RepooSecurityException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}
