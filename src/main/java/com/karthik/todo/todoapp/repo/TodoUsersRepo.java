package com.karthik.todo.todoapp.repo;

import com.karthik.todo.todoapp.entity.TodoUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoUsersRepo extends JpaRepository<TodoUsers,Integer> {

    Optional<TodoUsers> findByUserName(String userName);
}
