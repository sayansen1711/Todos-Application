package com.project.TodosApplication.todos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService todoService){
        super();
        this.todoService=todoService;
    }
    @RequestMapping(value="/todo-page", method=RequestMethod.GET)
    public String toDoController(ModelMap model){
        List<Todo> todosList=todoService.findByUsername("admin");
//        System.out.println(todos);
        model.addAttribute("todos",todosList);
        return "todos";
    }
}
