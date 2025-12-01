package com.project.TodosApplication.loginController;

import com.project.TodosApplication.service.AuthenticationService;
import com.project.TodosApplication.todos.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class LoginController {

    private final AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService){
        super();
        this.authenticationService=authenticationService;
    }
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String defaultPage(){
        return "login";
    }
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String toLoginPage(){
        return "login";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String toToDoPage(@RequestParam String username, String password, ModelMap model){
        if(authenticationService.authenticate(username,password)) {
            model.put("username", username);
//            model.put("todos",todoService.findByUsername(username)); //adds todo view to the model
            return "redirect:/todo-page"; //redirects and loads /todo-page
        }
        model.put("errorMessage","Invalid Credentials");
        return "login";
    }
}
