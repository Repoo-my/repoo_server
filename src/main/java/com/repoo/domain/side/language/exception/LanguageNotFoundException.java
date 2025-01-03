package com.repoo.domain.side.language.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class LanguageNotFoundException extends RepooException {
    public LanguageNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Language_NOT_FOUND", "어학을 찾을 수 없습니다.");
    }
}
