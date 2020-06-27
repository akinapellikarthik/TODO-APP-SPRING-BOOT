package com.karthik.todo.todoapp.exceptions;


import java.util.function.Supplier;

public class TodoNotFoundException extends Exception{

    public TodoNotFoundException(){

    }
    public TodoNotFoundException(String msg){
        super(msg);
    }


}
