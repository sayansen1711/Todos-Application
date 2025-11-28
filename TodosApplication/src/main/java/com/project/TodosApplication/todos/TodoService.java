package com.project.TodosApplication.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    static{
        todoList.add(new Todo(1,"Coursera","Learn AWS", LocalDate.now().plusMonths(2),false));
        todoList.add(new Todo(2,"Udemy","Learn Devops", LocalDate.now().plusMonths(5),false));
        todoList.add(new Todo(3,"EDEX","Learn Full Stack", LocalDate.now().plusMonths(12),false));
    }
    public List<Todo> findByUsername(String username){
        return todoList;
    }
}
