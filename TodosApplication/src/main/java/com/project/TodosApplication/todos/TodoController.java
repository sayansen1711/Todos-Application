package com.project.TodosApplication.todos;

import com.project.TodosApplication.dto.TodoDTO;
import com.project.TodosApplication.security.SpringSecurityConfig;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;
    private final SpringSecurityConfig securityConfig;

    public TodoController(TodoService todoService, TodoRepository todoRepository,SpringSecurityConfig securityConfig){
        super();
        this.todoService=todoService;
        this.securityConfig=securityConfig;
    }

    @RequestMapping(value="/todo-page", method=RequestMethod.GET)
    public String showTodoListPage(ModelMap model){
        List<TodoDTO> todosList=todoService.findByUsername(securityConfig.getLoggedInUserName());
        model.addAttribute("todosList",todosList);
        model.addAttribute("username",securityConfig.getLoggedInUserName());
        return "todosPage";
    }
    @GetMapping("/add-todo")
    public String showAddTodoPage(ModelMap model){
//        model.addAttribute("newTodoItem",new Todo()); //adds an empty Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        String username = securityConfig.getLoggedInUserName();
//        Todo todoObj=new Todo(0,username,"",LocalDate.now(),false);
//        model.addAttribute("username",username);
        model.addAttribute("newTodoItem", new TodoDTO()); //adds a pre-filled Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        return "add-todo";
    }
    @PostMapping("/add-todo")
    public String addNewTodoActivity(ModelMap model, @Valid @ModelAttribute("newTodoItem") TodoDTO todoDTO, BindingResult result){
        if(result.hasErrors()){
//            model.addAttribute("newTodoItem", todos);
            return "add-todo";
        }
        String username = securityConfig.getLoggedInUserName();
        todoService.addTodo(todoDTO, username); //Spring automatically fills the Todo object based on form path values
        return "redirect:/todo-page";  //-> opening todos page: showTodoListPage
    }

    @RequestMapping("delete-todo")
    public String deleteTodoItem(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:/todo-page";
    }
    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        TodoDTO todoObject=todoService.findTodoById(id);
        model.addAttribute("newTodoItem",todoObject);
        return "add-todo"; //open up add-todo page
    }
    @PostMapping("update-todo")
    public String updateTodoActivity(ModelMap model,
                                     @Valid @ModelAttribute("newTodoItem") TodoDTO todoDTO,
                                     BindingResult result) throws AccessDeniedException {
        if(result.hasErrors()){
            return "add-todo"; //open up add-todo page
        }
        String username = securityConfig.getLoggedInUserName();
        todoService.updateTodo(todoDTO, username);
        return "redirect:/todo-page"; //going to Todos page
    }
    @PostMapping("update-todo-status")
    public String updateTodoStatus(@RequestParam int id, @RequestParam(required = false) boolean done) throws AccessDeniedException {
        TodoDTO todoDTO=todoService.findTodoById(id);
        todoDTO.setDone(done);
        todoService.updateTodo(todoDTO, securityConfig.getLoggedInUserName());
        return "redirect:/todo-page";
    }
}
