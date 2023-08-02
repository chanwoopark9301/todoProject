package com.todoApp.ToDo_PPOMODORO.controller;

import com.todoApp.ToDo_PPOMODORO.Dto.MultiResponseDto;
import com.todoApp.ToDo_PPOMODORO.Dto.SingleResponseDto;
import com.todoApp.ToDo_PPOMODORO.Dto.ToDoDto;
import com.todoApp.ToDo_PPOMODORO.Entity.ToDo;
import com.todoApp.ToDo_PPOMODORO.maper.ToDoMapper;
import com.todoApp.ToDo_PPOMODORO.repository.ToDoRepository;
import com.todoApp.ToDo_PPOMODORO.service.ToDoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoMapper mapper;

    public ToDoController(ToDoService toDoService, ToDoMapper mapper) {
        this.toDoService = toDoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postToDo(@RequestBody ToDoDto.PostToDoDto requestBody) {
        ToDo toDo= mapper.ToDoPostDtoToToDo(requestBody);

        ToDo createdToDo = toDoService.createToDo(toDo);
        ToDoDto.ResponseToDoDto response = mapper.todoToToDoResponseDto(createdToDo);
        return new ResponseEntity(new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchToDo(@PathVariable("id") long id,
                                   @RequestBody ToDoDto.PatchToDoDto requestBody){
        requestBody.setId(id);

        ToDo toDo =
                toDoService.updateToDo(mapper.ToDoPatchDtoToToDo(requestBody));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.todoToToDoResponseDto(toDo)),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getToDo(@PathVariable("id") long id){
        ToDo toDo = toDoService.readToDo(id);
        return new ResponseEntity(
                new SingleResponseDto<>(mapper.todoToToDoResponseDto(toDo)),
                HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getToDos(@RequestParam int page,
                                   @RequestParam int size){
        Page<ToDo> pageToDos = toDoService.readToDos(page-1, size);
        List<ToDo> toDos = pageToDos.getContent();
        return new ResponseEntity(
                new MultiResponseDto<>(mapper.todosToToDoResponses(toDos),
                        pageToDos),
                HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteToDos(){
        toDoService.deleteToDos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDo(@PathVariable("id") long id){
        toDoService.deleteToDo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}