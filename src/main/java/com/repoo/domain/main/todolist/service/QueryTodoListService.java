package com.repoo.domain.main.todolist.service;

import com.repoo.domain.main.calendar.service.QueryCalendarService;
import com.repoo.domain.main.todolist.domain.TodoList;
import com.repoo.domain.main.todolist.presentation.dto.res.ResponseTodoList;
import com.repoo.domain.main.todolist.service.implementation.TodoListReader;
import com.repoo.domain.main.user.service.QueryUsersService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryTodoListService {

    private final TodoListReader todoListReader;
    private final QueryCalendarService queryCalendarService;
    private final QueryUsersService queryUsersService;

    public ResponseTodoList getTodoList(Long id){
        TodoList todoList = todoListReader.findById(id);

        return new ResponseTodoList(
                todoList.getTodoListId(),
                todoList.getCalendar().getCalendarId(),
                todoList.getContents(),
                todoList.getTags()
        );
    }

    public List<ResponseTodoList> getTodoLists(Long userId, Long calendarId){
        List<TodoList> todoLists = todoListReader.findAllByCalendar(queryCalendarService.getCalendar(calendarId, userId));
        List<ResponseTodoList> responseTodoLists = new ArrayList<>();

        for(TodoList todoList: todoLists){
            responseTodoLists.add(new ResponseTodoList(
                    todoList.getTodoListId(),
                    todoList.getCalendar().getCalendarId(),
                    todoList.getContents(),
                    todoList.getTags()
            ));
        }

        return responseTodoLists;
    }

}
