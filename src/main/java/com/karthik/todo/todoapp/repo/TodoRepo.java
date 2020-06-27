package com.karthik.todo.todoapp.repo;

import com.karthik.todo.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update todo t set t.description =:description, t.isdone=:isdone, t.TODO_DATE=:TODO_DATE where t.id = :id",nativeQuery = true)
    Integer updateTodo(@Param("id") Integer id,
                    @Param("description") String description,
                    @Param("isdone") Boolean isdone,
                    @Param("TODO_DATE") Date TODO_DATE
                    );

}
