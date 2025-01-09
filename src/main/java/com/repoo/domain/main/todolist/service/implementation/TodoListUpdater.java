package com.repoo.domain.main.todolist.service.implementation;

import com.repoo.domain.main.todolist.domain.TodoList;
import com.repoo.domain.main.todolist.domain.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoListUpdater {

    private final TodoListRepository todoListRepository;

    public void update(TodoList updatableTodoList, TodoList todoList){
        updatableTodoList.update(
                todoList.getCalendar(),
                todoList.getContents(),
                todoList.getTags()
        );

        todoListRepository.save(updatableTodoList);
    }
}
