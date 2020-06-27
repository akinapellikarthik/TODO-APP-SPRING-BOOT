package com.karthik.todo.todoapp.utilities;

import com.karthik.todo.todoapp.config.TodoConfig;
import com.karthik.todo.todoapp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoUtilities {

    @Autowired
    private TodoConfig todoConfig;

    public Todo todoDtoToEntityConverter(com.karthik.todo.todoapp.dto.Todo todo){
        return todoConfig.modelMapper().map(todo,Todo.class);
    }
}
