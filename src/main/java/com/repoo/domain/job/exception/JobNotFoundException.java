package com.repoo.domain.job.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class JobNotFoundException extends RepooException {
    public JobNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Job_NOT_FOUND", "직무을 찾을 수 없습니다.");
    }
}
