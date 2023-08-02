package com.todoApp.ToDo_PPOMODORO.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String title;
    @Column
    int todoOrder;
    @Column(nullable = false)
    boolean completed;
}
