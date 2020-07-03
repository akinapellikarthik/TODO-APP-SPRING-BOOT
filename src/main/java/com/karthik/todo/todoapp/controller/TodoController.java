package com.karthik.todo.todoapp.controller;

import com.karthik.todo.todoapp.dto.Todo;
import com.karthik.todo.todoapp.dto.TodoUser;
import com.karthik.todo.todoapp.exceptions.TodoNotFoundException;
import com.karthik.todo.todoapp.exceptions.UserNotFoundException;
import com.karthik.todo.todoapp.service.TodoServices;
import com.karthik.todo.todoapp.utilities.TodoUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoServices services;

    @Autowired
    private TodoUtilities todoUtilities;

    @GetMapping("/testalive")
    public String testAlive(){
        return "I am alive";
    }

    @PostMapping("/authenticateUser")
    public boolean authenicateUser(@Valid @RequestBody TodoUser user) throws UserNotFoundException {
        return services.authenicateUser(user);
    }

    @PostMapping("/todo")
    public ResponseEntity<com.karthik.todo.todoapp.entity.Todo> saveTodo(@Valid @RequestBody Todo todo){
        System.out.println(todo);
        com.karthik.todo.todoapp.entity.Todo t = todoUtilities.todoDtoToEntityConverter(todo);
        return new ResponseEntity<>(services.saveTodo(t), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<com.karthik.todo.todoapp.entity.Todo> allTodos(){
        return services.getAllTodo();
    }

    @DeleteMapping("/todo")
    public boolean deleteTodoById(@RequestParam("id") Integer id){
        return services.deleteTodoById(id);
    }

    @PutMapping("/todo")
    public void updateTodo(@Valid @RequestBody com.karthik.todo.todoapp.entity.Todo todo) throws TodoNotFoundException {

        Optional<com.karthik.todo.todoapp.entity.Todo> todoTemp = services.getTodoById(todo.getId());
        if(!todoTemp.isPresent())
            throw new TodoNotFoundException("Todo doesn't exists with this ID:"+todo.getId());
        else
        {
            services.updateTodo(todo);
        }


    }

    @GetMapping("/todoNotCompletedCount")
    public Integer todoNotCompletedCount(){
        return this.services.getTodoNotCompletedCount();
    }

}
