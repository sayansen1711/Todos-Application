package com.project.TodosApplication.todos;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    private static int idCounter=0;
    static{
        todoList.add(new Todo(++idCounter,"Coursera","Learn AWS", LocalDate.now().plusMonths(2),false));
        todoList.add(new Todo(++idCounter,"Udemy","Learn Devops", LocalDate.now().plusMonths(5),false));
        todoList.add(new Todo(++idCounter,"EDEX","Learn Full Stack", LocalDate.now().plusMonths(12),false));
    }
    public List<Todo> findByUsername(String username){
        return todoList;
    }
    public void addTodo(String username,String description, LocalDate date){
        Todo todoObj=new Todo(++idCounter,username,description,date,false);
        todoList.add(todoObj);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate=todoVar -> todoVar.getId()==id;
        todoList.removeIf(predicate);
    }
    public Todo findTodoById(int id){
        Predicate<? super Todo> predicate=todoVar->todoVar.getId()==id;
        Todo todoObject=todoList.stream().filter(predicate).findFirst().get();
        return todoObject;
    }
    public void updateTodo(@Valid Todo todoObject){
        deleteById(todoObject.getId());
        addTodo(todoObject.getUsername(), todoObject.getDescription(),todoObject.getDate());
    }
}
