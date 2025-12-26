package com.project.TodosApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpDTO { //used for sign up form

    @NotBlank(message="Username Field cannot be blank")
    private String username;

    @Email(message="Email Field cannot be blank")
    @NotBlank
    private String email;

    @NotBlank(message = "Password Field cannot be blank")
    @Size(min = 6, max = 32, message = "Password length must be between 6 and 32")
    private String password;

    public SignUpDTO() {

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
