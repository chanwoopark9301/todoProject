package com.todoApp.ToDo_PPOMODORO.maper;

import com.todoApp.ToDo_PPOMODORO.Dto.ToDoDto;
import com.todoApp.ToDo_PPOMODORO.Entity.ToDo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ToDoMapper {

    ToDo ToDoPostDtoToToDo(ToDoDto.PostToDoDto postToDoDto);

    ToDo ToDoPatchDtoToToDo(ToDoDto.PatchToDoDto patchToDoDto);

    ToDoDto.ResponseToDoDto todoToToDoResponseDto(ToDo toDo);

    List<ToDoDto.ResponseToDoDto> todosToToDoResponses(List<ToDo> toDos);
}
