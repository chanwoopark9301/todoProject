package com.todoApp.ToDo_PPOMODORO.repository;

import com.todoApp.ToDo_PPOMODORO.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
