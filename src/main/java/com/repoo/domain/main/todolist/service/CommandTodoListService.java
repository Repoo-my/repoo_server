package com.repoo.domain.main.todolist.service;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.service.QueryCalendarService;
import com.repoo.domain.main.todolist.domain.TodoList;
import com.repoo.domain.main.todolist.presentation.dto.req.RequestTodoList;
import com.repoo.domain.main.todolist.presentation.dto.res.ResponseTodoList;
import com.repoo.domain.main.todolist.service.implementation.TodoListCreator;
import com.repoo.domain.main.todolist.service.implementation.TodoListDeleter;
import com.repoo.domain.main.todolist.service.implementation.TodoListReader;
import com.repoo.domain.main.todolist.service.implementation.TodoListUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTodoListService {

    private final TodoListCreator todoListCreator;
    private final TodoListReader todoListReader;
    private final TodoListUpdater todoListUpdater;
    private final TodoListDeleter todoListDeleter;
    private final QueryCalendarService queryCalendarService;

    public void create(RequestTodoList todoList, Long userId){
        todoListCreator.save(new TodoList(
                queryCalendarService.getCalendar(todoList.calendarId(), userId),
                todoList.contents(),
                todoList.tags()
        ));
    }

    public void update(ResponseTodoList requestTodoList, Long id, Long userId, Long calendarId){
        Calendar calendar = queryCalendarService.getCalendar(calendarId, userId);
        TodoList todoList = todoListReader.findById(id);

        if(todoList.getCalendar().equals(calendar)) {
            todoListUpdater.update(
                    todoList,
                    new TodoList(
                            calendar,
                            requestTodoList.contents(),
                            requestTodoList.tags()
                    )
            );
        }
    }

    public void delete(Long id, Long userId, Long calendarId){
        Calendar calendar = queryCalendarService.getCalendar(calendarId, userId);
        TodoList todoList = todoListReader.findById(id);

        if(todoList.getCalendar().equals(calendar)) {
            todoListDeleter.delete(id);
        }
    }

}
