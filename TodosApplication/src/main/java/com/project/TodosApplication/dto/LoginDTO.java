package com.project.TodosApplication.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO { //used for login form

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
