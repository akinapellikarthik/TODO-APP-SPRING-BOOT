package com.karthik.todo.todoapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {
    @NotNull(message = "todoDescription cannot be empty")
        private String todoDescription;

    @NotNull(message = "todo isdone cannot be empty")
    private Boolean isDone;

    @NotNull(message = "todo date cannot be empty")
    private Date todo_date;

    @Override
    public String toString() {
        return this.todoDescription +":"+ this.isDone;
    }
}
