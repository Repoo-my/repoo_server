package com.repoo.jobgroup.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class JobGroupNotFoundException extends RepooException {
    public JobGroupNotFoundException() {
        super(HttpStatus.NOT_FOUND, "JobGroup_NOT_FOUND", "직군을 찾을 수 없습니다.");
    }
}
