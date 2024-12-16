package com.repoo.global.jwt.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class DuplicateLoginException extends RepooException {

    public DuplicateLoginException() {
        super(HttpStatus.UNAUTHORIZED, "DUPLICATE_LOGIN", "이미 로그인한 상태입니다.");
    }
}
