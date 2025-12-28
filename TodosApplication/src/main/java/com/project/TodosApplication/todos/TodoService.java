package com.project.TodosApplication.todos;

import com.project.TodosApplication.dto.TodoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.nio.file.AccessDeniedException;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    //Constructor Injection
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    //Create / Add entry to DB
    public void addTodo(TodoDTO todoDTO, String username){
        Todo todo = new Todo();
        todo.setUsername(username);
        todo.setDescription(todoDTO.getDescription());
        todo.setDate(todoDTO.getDate());
        todo.setDone(false);
        todoRepository.save(todo);
    }

    //Read by Username
    public List<TodoDTO> findByUsername(String username){
        return todoRepository.findByUsername(username).stream().map(this::convertToDTO).toList();
    }
    //Read by ID
    public TodoDTO findTodoById(int id){
        Todo todo=todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
        return convertToDTO(todo);
    }
    //Update Object
    public void updateTodo(@Valid TodoDTO todoDTO, String username) throws AccessDeniedException {
        Todo todo=todoRepository.findById(todoDTO.getId()).orElseThrow(()-> new RuntimeException("Todo not found"));
        //Security check
        if(!todo.getUsername().equals(username))
            throw new AccessDeniedException("Not your todo");

        todo.setDescription(todoDTO.getDescription());
        todo.setDate(todoDTO.getDate());
        todo.setDone(todoDTO.getDone());

        todoRepository.save(todo);
    }
    //Delete by ID
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
    private TodoDTO convertToDTO(Todo todo) {
        TodoDTO dto = new TodoDTO();
        dto.setId(todo.getId());
        dto.setDescription(todo.getDescription());
        dto.setDate(todo.getDate());
        dto.setDone(todo.getDone());
        return dto;
    }
}
