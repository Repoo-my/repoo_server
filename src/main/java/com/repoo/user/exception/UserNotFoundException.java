package com.repoo.user.exception;

import com.repoo.common.RepooException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RepooException {
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User_NOT_FOUND", "유저를 찾을 수 없습니다.");
    }
}
