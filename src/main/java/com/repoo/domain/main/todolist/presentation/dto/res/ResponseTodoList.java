package com.repoo.domain.main.todolist.presentation.dto.res;

public record ResponseTodoList(
        Long todoListId,
        Long calendarId,
        String contents,
        String[] tags
) {
}
