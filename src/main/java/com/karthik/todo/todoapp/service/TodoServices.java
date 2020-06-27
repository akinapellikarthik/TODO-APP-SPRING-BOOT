package com.karthik.todo.todoapp.service;

import com.karthik.todo.todoapp.dto.TodoUser;
import com.karthik.todo.todoapp.entity.Todo;
import com.karthik.todo.todoapp.entity.TodoUsers;
import com.karthik.todo.todoapp.exceptions.UserNotFoundException;
import com.karthik.todo.todoapp.repo.TodoRepo;
import com.karthik.todo.todoapp.repo.TodoUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class TodoServices {

    @Autowired
    private TodoUsersRepo todoUsersRepo;

    @Autowired
    private TodoRepo todoRepo;

    public boolean authenicateUser(@Valid TodoUser user) throws UserNotFoundException {
        String username = user.getUsername();
        TodoUsers u = todoUsersRepo
                .findByUserName(username)
                .orElseThrow(()-> new UserNotFoundException(("User doesn't exists")));

        return username.equalsIgnoreCase(u.getUserName()) && user.getPasswd().equalsIgnoreCase(u.getPassword());

    }

    public Todo saveTodo(Todo todo){
        //return todoRepo.save(todo);
        return todoRepo.saveAndFlush(todo);
    }

    public List<Todo> getAllTodo(){

        return todoRepo.findAll();
    }

    public boolean deleteTodoById(Integer todoId){
        boolean isTodoExists = todoRepo.existsById(todoId);
        todoRepo.deleteById(todoId);
        return isTodoExists;
    }


    public Integer updateTodo(Todo todo) {
       return todoRepo.updateTodo(todo.getId(),todo.getTodoDescription(),todo.getIsDone(),todo.getTodo_date());
    }

    public Optional<Todo> getTodoById(Integer id){
        return this.todoRepo.findById(id);
    }
}
