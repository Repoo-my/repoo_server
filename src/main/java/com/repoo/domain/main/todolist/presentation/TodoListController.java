package com.repoo.domain.main.todolist.presentation;

import com.repoo.domain.main.calendar.presentation.dto.req.RequestCalendar;
import com.repoo.domain.main.todolist.presentation.dto.req.RequestTodoList;
import com.repoo.domain.main.todolist.presentation.dto.res.ResponseTodoList;
import com.repoo.domain.main.todolist.service.CommandTodoListService;
import com.repoo.domain.main.todolist.service.QueryTodoListService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todolist")
public class TodoListController {

    private final QueryTodoListService queryTodoListService;
    private final CommandTodoListService commandTodoListService;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    @GetMapping("/{todoListId}")
    public ResponseTodoList getTodoList(
            @RequestHeader String accessToken,
            @PathVariable Long todoListId
    ){
        return queryTodoListService.getTodoList(todoListId);
    }

    @GetMapping("/{calendarId}")
    public List<ResponseTodoList> getTodoLists(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId
    ){
        return queryTodoListService.getTodoLists(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                calendarId
        );
    }

    @PostMapping
    public void addTodoList(
            @RequestHeader String accessToken,
            @RequestBody RequestTodoList todoList
    ){
        commandTodoListService.create(
                todoList,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @PutMapping("/{calendarId}/{todoListId}")
    public void updateTodoList(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId,
            @PathVariable Long todoListId,
            @RequestBody RequestTodoList todoList
    ){
        commandTodoListService.update(
                todoList,
                todoListId,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                calendarId
        );
    }

    @DeleteMapping("/{calendarId}/{todoListId}")
    public void deleteTodoList(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId,
            @PathVariable Long todoListId
    ){
        commandTodoListService.delete(
                todoListId,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken),
                calendarId
        );
    }


}
