package com.repoo.domain.main.todolist.service.implementation;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.todolist.domain.TodoList;
import com.repoo.domain.main.todolist.domain.repository.TodoListRepository;
import com.repoo.domain.main.todolist.exception.TodoListNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListReader {

    private final TodoListRepository todoListRepository;

    public TodoList findById(Long id){
        return todoListRepository.findById(id)
                .orElseThrow(TodoListNotFoundException::new);
    }

    public List<TodoList> findAllByCalendar(Calendar calendar){
        return todoListRepository.findAllByCalendar(calendar);
    }
}
