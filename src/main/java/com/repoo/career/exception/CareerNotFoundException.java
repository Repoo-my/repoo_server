package com.repoo.career.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class CareerNotFoundException extends RepooException {
    public CareerNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Career_NOT_FOUND", "경력을 찾을 수 없습니다.");
    }
}
