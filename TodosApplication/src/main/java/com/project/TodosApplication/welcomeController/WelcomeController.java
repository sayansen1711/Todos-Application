package com.project.TodosApplication.welcomeController;

import com.project.TodosApplication.service.AuthenticationService;
import com.project.TodosApplication.todos.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class WelcomeController {

    private final AuthenticationService authenticationService;
    public WelcomeController(AuthenticationService authenticationService){
        super();
        this.authenticationService=authenticationService;
    }
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String goToLoginPage(ModelMap model){
        model.put("username","user");
        return "welcome";
    }
//    @GetMapping("/login")
    @GetMapping("/welcome")
    public String welcomePage(ModelMap map){
        map.put("username","user");
//        return "login";
        return "welcome";
    }
//    @RequestMapping(value="/welcome", method=RequestMethod.GET)
//    public String toLoginPage(ModelMap map){
//        map.put("username","user1");
//        return "welcome";
//    }
//    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String toToDoPage(@RequestParam String username, String password, ModelMap model){
        if(authenticationService.authenticate(username,password)) {
            model.put("username", username);
//            model.addAttribute(("todos",todoService.findByUsername(username)); // adds todo view to the model
            return "welcome"; //redirects and loads /todo-page
        }
        model.addAttribute("errorMessage","Invalid Credentials");
        return "login";
    }
}
