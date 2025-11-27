package com.project.TodosApplication.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
