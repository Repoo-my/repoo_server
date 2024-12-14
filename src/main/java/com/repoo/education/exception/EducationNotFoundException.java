package com.repoo.education.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class EducationNotFoundException extends RepooException {
    public EducationNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Education_NOT_FOUND", "학력을 찾을 수 없습니다.");
    }
}
