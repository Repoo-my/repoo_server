package com.repoo.domain.enterprise.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class EnterpriseNotFoundException extends RepooException {
    public EnterpriseNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Enterprise_NOT_FOUND", "기업을 찾을 수 없습니다.");
    }
}
