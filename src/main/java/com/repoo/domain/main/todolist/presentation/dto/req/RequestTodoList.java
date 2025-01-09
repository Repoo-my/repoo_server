package com.repoo.domain.main.todolist.presentation.dto.req;

public record RequestTodoList(
        Long calendarId,
        String contents,
        String[] tags
) {
}
