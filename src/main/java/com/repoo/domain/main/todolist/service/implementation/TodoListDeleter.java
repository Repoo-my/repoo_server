package com.repoo.domain.main.todolist.service.implementation;

import com.repoo.domain.main.todolist.domain.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoListDeleter {

    private final TodoListRepository todoListRepository;

    public void delete(Long id) {
        todoListRepository.deleteById(id);
    }
}
