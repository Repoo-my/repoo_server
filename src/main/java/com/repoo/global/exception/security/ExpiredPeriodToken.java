package com.repoo.global.exception.security;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class ExpiredPeriodToken extends RepooException {
    public ExpiredPeriodToken() {
        super(HttpStatus.NOT_FOUND, "EXPIRED_PERIOD_TOKEN", "만료된 토큰입니다.");
    }
}
