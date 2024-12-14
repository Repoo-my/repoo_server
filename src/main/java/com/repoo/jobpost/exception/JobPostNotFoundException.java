package com.repoo.jobpost.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class JobPostNotFoundException extends RepooException {
    public JobPostNotFoundException() {
        super(HttpStatus.NOT_FOUND, "JobPost_NOT_FOUND", "공식 채용을 찾을 수 없습니다.");
    }
}
