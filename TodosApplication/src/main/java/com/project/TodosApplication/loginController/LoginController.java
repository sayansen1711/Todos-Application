package com.project.TodosApplication.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String defaultPage(){
        return "login";
    }
    @GetMapping("/login")
    public String toLoginPage(@RequestParam String name, ModelMap map){
        map.put("firstname",name);
        return "login";
    }
}
