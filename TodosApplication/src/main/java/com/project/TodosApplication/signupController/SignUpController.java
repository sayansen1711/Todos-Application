package com.project.TodosApplication.signupController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String toSignUpPage(){
        return "signup";
    }
}
