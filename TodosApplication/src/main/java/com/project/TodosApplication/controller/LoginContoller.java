package com.project.TodosApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginContoller {
    @GetMapping("/perform_login")
    public String login(){
        return "login";
    }
}
