package com.repoo.domain.authentication.oauth.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class SocialUserExistedException extends RepooException {
    public SocialUserExistedException() {
        super(HttpStatus.CONFLICT, "USER_EXISTED", "유저가 이미 존재합니다.");
    }
}
