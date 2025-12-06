package com.project.TodosApplication.todos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
        model.addAttribute("todosList",todosList);
        return "todosPage";
    }
    @GetMapping("/add-todo")
    public String showAddTodoPage(ModelMap model){
//        model.addAttribute("newTodoItem",new Todo()); //adds an empty Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        String username=model.get("username").toString();
        Todo todoObj=new Todo(0,username,"",LocalDate.now(),false);
        model.addAttribute("newTodoItem",todoObj); //adds a pre-filled Todo object to the Model which is mapped to the modelAttribute=todos in view(JSP)
        return "add-todo";
    }
    @PostMapping("/add-todo")
    public String addNewTodoActivity(ModelMap model, @Valid @ModelAttribute("newTodoItem") Todo todos, BindingResult result, HttpSession session){
        String username = (String) session.getAttribute("username");
        todos.setUsername(username);
        if(result.hasErrors()){
            model.addAttribute("newTodoItem", todos);
            return "add-todo";
        }
        todoService.addTodo(todos.getUsername(), todos.getDescription(), todos.getDate()); //Spring automatically fills the Todo object based on form path values
        return "redirect:/todo-page";  //-> opening todos page: showTodoListPage
    }

    @RequestMapping("delete-todo")
    public String deleteTodoItem(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:/todo-page";
    }
    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todoObject=todoService.findTodoById(id);
        model.addAttribute("newTodoItem",todoObject);
        return "add-todo"; //open up add-todo page
    }
    @PostMapping("update-todo")
    public String updateTodoActivity(ModelMap model,
                                     @Valid @ModelAttribute("newTodoItem") Todo todos,
                                     BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "add-todo"; //open up add-todo page
        }
        String username=session.getAttribute("username").toString();
        todos.setUsername(username);
        todoService.updateTodo(todos);
        return "redirect:todo-page"; //going to Todos page
    }
}
