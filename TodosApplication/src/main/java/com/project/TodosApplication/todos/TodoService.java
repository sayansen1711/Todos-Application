package com.project.TodosApplication.todos;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    //Constructor Injection
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    //Create / Add entry to DB
    public void addTodo(String username,String description, LocalDate date){
        Todo todo = new Todo();
        todo.setUsername(username);
        todo.setDescription(description);
        todo.setDate(date);
        todo.setDone(false);
        todoRepository.save(todo);
    }

    //Read by Username
    public List<Todo> findByUsername(String username){
        return todoRepository.findByUsername(username);
    }
    //Read by ID
    public Todo findTodoById(int id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }
    //Update Object
    public void updateTodo(@Valid Todo todoObject){
        todoRepository.save(todoObject);
    }
    //Delete by ID
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
}
