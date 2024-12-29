package com.repoo.domain.main.curriculumvitae.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class CurriculumVitaeNotFoundException extends RepooException {
    public CurriculumVitaeNotFoundException() {
        super(HttpStatus.NOT_FOUND, "CurriculumVitae_NOT_FOUND", "이력서를 찾을 수 없습니다.");
    }
}
