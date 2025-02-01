package com.repoo.domain.main.myjobpost.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class MyJobPostNotFoundException extends RepooException {
    public MyJobPostNotFoundException() {
        super(HttpStatus.NOT_FOUND, "MyJobPost_NOT_FOUND", "저장한 공채를 찾을 수 없습니다.");
    }
}
