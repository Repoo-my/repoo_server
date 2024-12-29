package com.repoo.domain.authentication.auth.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class AuthUserNotFoundException extends RepooException {

    public AuthUserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "USER_NOT_FOUND","유저를 찾을 수 없습니다.");
    }
}
