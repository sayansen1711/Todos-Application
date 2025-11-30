package com.project.TodosApplication.signupController;

import com.project.TodosApplication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String toSignUpPage(){
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@RequestParam String fname, String email, String password, ModelMap model){
        model.put("fname",fname);
        model.put("email", email);
        model.put("password",password);
        if(authenticationService.validRegistration(fname,email,password))
            return "todos";
        else
            return "signup";
    }
}
