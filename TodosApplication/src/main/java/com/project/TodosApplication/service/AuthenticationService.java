package com.project.TodosApplication.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        //validate from DB
        if(username.equals("admin") && password.equals("root"))
            return true;
        return false;
    }
    public boolean validRegistration(String username, String email, String password){
        if(username.contains(" ")){
            if(email.contains("@") && email.endsWith(".com")){
                if(password.length()>=8 && password.length()<=32)
                    return true;
            }
        }
        return false;
    }
}
