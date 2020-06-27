package com.karthik.todo.todoapp.exceptions;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException userNotFoundException){
        return userNotFoundException.getMessage();
    }
}
