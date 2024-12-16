package com.repoo.auth.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends RepooException {
    public InvalidCredentialsException() {
        super(HttpStatus.UNAUTHORIZED, "INVALID_CREDENTIALS", "잘못된 이메일 또는 비밀번호입니다.");
    }
}
