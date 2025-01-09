package com.repoo.domain.main.todolist.domain.repository;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.todolist.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findAllByCalendar(Calendar calendar);
}
