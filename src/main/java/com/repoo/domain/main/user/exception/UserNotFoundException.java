package com.repoo.domain.main.user.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RepooException {
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User_NOT_FOUND", "유저를 찾을 수 없습니다.");
    }
}
