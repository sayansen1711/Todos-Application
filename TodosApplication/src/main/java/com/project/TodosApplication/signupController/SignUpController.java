package com.project.TodosApplication.signupController;

import com.project.TodosApplication.security.SpringSecurityConfig;
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

    private SpringSecurityConfig springSecurityConfig;
    public SignUpController(SpringSecurityConfig springSecurityConfig){
        this.springSecurityConfig=springSecurityConfig;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String toSignUpPage(){
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@RequestParam String username, String email, String password, ModelMap model){
        model.put("username", username);
        model.put("email", email);
        model.put("password",password);
        return "welcome";
    }
}
