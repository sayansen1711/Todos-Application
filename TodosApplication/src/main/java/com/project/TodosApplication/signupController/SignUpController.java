package com.project.TodosApplication.signupController;

import com.project.TodosApplication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class SignUpController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String toSignUpPage(){
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@RequestParam String username, String email, String password, ModelMap model){
        model.put("username",username.substring(0,username.indexOf(' ')));
        model.put("email", email);
        model.put("password",password);
        if(authenticationService.validRegistration(username,email,password))
            return "welcome";
        else
            return "signup";
    }
}
