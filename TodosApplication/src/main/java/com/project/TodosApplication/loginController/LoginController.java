package com.project.TodosApplication.loginController;

import com.project.TodosApplication.security.SpringSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private SpringSecurityConfig springSecurityConfig;
    public LoginController(SpringSecurityConfig springSecurityConfig){
        this.springSecurityConfig=springSecurityConfig;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, ModelMap model) {
        if(error!=null){ //reading the error flag from View
            model.addAttribute("loginError","Invalid username or password");
        }
        return "login"; // Refers to your login view name (e.g., login.html, login.jsp)
    }
}
