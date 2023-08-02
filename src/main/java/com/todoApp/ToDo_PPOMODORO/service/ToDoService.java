package com.todoApp.ToDo_PPOMODORO.service;

import com.todoApp.ToDo_PPOMODORO.Entity.ToDo;
import com.todoApp.ToDo_PPOMODORO.repository.ToDoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(ToDo toDo){
        ToDo savedTodo = toDoRepository.save(toDo);
        return savedTodo;
    }
    public ToDo updateToDo(ToDo toDo){
        ToDo findTodo = findVerifiedToDo(toDo.getId());

        Optional.ofNullable(toDo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(toDo.getTodoOrder())
                .ifPresent(todoOrder -> findTodo.setTodoOrder(todoOrder));
        findTodo.setCompleted(toDo.isCompleted());
        return toDoRepository.save(findTodo);
    }



    public ToDo readToDo(long id){return findVerifiedToDo(id);}
    public Page<ToDo> readToDos(int page, int size){
        return toDoRepository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
    public void deleteToDo(long id){
        ToDo findToDo = findVerifiedToDo(id);

        toDoRepository.delete(findToDo);
    }

    public void deleteToDos(){

        toDoRepository.deleteAll();
    }
    private ToDo findVerifiedToDo(long id) {
        Optional<ToDo> optionalToDo =
                toDoRepository.findById(id);
        ToDo findToDo =
                optionalToDo.orElseThrow(()->new RuntimeException());
        return findToDo;
    }
}
