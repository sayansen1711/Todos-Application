package com.project.TodosApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello World";
    }
    @RequestMapping("/hello2")
    @ResponseBody
    public String helloWorld(){
        return "Hello World2";
    }
}
