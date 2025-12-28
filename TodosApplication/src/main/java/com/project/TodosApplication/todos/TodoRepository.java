package com.project.TodosApplication.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //DAO (data access object)
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUsername(String username);

//    Todo findById(long id);
}
