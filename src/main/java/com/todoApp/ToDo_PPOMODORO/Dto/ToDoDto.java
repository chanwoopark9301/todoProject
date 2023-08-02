package com.todoApp.ToDo_PPOMODORO.Dto;

import lombok.Getter;
import lombok.Setter;

public class ToDoDto {
    @Getter
    @Setter
    public static class PostToDoDto{
        String title;
        int todoOrder;
        boolean completed;
    }
    @Getter
    @Setter
    public static class PatchToDoDto{
        long id;
        String title;
        int todoOrder;
        boolean completed;
    }

    @Getter
    @Setter
    public static class ResponseToDoDto {
        long id;
        String title;
        int todoOrder;
        boolean completed;
    }
}
