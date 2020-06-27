package com.karthik.todo.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoUser {

    @NotNull(message = "UserID is mandatory")
    private String username;

    @NotNull(message = "Password is mandatory")
    private String passwd;

    public String toString(){
        return "username is:"+username+" password is:"+passwd;
    }
}
