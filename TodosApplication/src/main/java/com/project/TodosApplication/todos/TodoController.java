package com.project.TodosApplication.todos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService todoService){
        super();
        this.todoService=todoService;
    }
    @RequestMapping(value="/todo-page")
    public String toDoController(ModelMap model){
//        model.put("todoList",todoService.findByUsername(username));
        model.put("todoList",todoService.findByUsername("admin"));
        return "todos";
    }
}
