package com.project.TodosApplication.todos;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String showTodoListPage(ModelMap model){
        List<Todo> todosList=todoService.findByUsername("admin");
        model.addAttribute("todos",todosList);
        return "todos";
    }
    @GetMapping("/add-todo")
    public String showAddTodoPage(ModelMap model){
//        model.addAttribute("todos",new Todo()); //adds an empty Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        String username=model.get("username").toString();
        Todo todoObj=new Todo(0,username,"Description",LocalDate.now(),false);
        model.addAttribute("todos",todoObj); //adds a pre-filled Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        return "add-todo";
    }
    @PostMapping("/add-todo")
    public String addNewTodoActivity(ModelMap model, Todo todos, BindingResult result, HttpSession session){
        String username = (String) session.getAttribute("username");
        todos.setUsername(username);
        todoService.addTodo(todos.getUsername(), todos.getDescription(), todos.getDate()); //Spring automatically fills the Todo object based on form path values
        return "redirect:/todo-page";
    }
}
