package com.project.TodosApplication.loginController;

import com.project.TodosApplication.security.SpringSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private SpringSecurityConfig springSecurityConfig;
    public LoginController(SpringSecurityConfig springSecurityConfig){
        this.springSecurityConfig=springSecurityConfig;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Refers to your login view name (e.g., login.html, login.jsp)
    }
}
