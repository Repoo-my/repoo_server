package com.repoo.curriculumvitae.exception;

import com.repoo.common.RepooException;
import org.springframework.http.HttpStatus;

public class CurriculumVitaeNotFoundException extends RepooException {
    public CurriculumVitaeNotFoundException() {
        super(HttpStatus.NOT_FOUND, "CurriculumVitae_NOT_FOUND", "이력서를 찾을 수 없습니다.");
    }
}
