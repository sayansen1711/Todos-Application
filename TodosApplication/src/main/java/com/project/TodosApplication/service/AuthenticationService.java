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
}
