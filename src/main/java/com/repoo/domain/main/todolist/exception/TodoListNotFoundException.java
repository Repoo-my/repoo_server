package com.repoo.domain.main.todolist.exception;

import com.repoo.global.exception.RepooException;
import org.springframework.http.HttpStatus;

public class TodoListNotFoundException extends RepooException {
    public TodoListNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Calendar_NOT_FOUND", "일정을 찾을 수 없습니다.");
    }
}
