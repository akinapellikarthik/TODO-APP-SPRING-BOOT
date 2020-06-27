package com.karthik.todo.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "todo")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "todo_sequence")
    private Integer id;

    @Column(name = "description")
    private String todoDescription;

    @Column(name = "isdone")
    private Boolean isDone;

    @Column(name = "TODO_DATE")
    private Date todo_date;

}
