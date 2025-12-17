package com.project.TodosApplication.welcomeController;

import com.project.TodosApplication.security.SpringSecurityConfig;
import com.project.TodosApplication.todos.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    private final SpringSecurityConfig securityConfig;

    public WelcomeController(SpringSecurityConfig securityConfig){
        this.securityConfig=securityConfig;
    }

    @GetMapping("/welcome")
    public String welcomePage(ModelMap map){
        map.put("username",securityConfig.getLoggedInUserName());
        return "welcome";
    }
}
