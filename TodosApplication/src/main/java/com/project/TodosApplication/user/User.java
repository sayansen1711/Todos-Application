package com.project.TodosApplication.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")  //custom name for table in todosDB
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String role;

    public User(){}
    public User(String username, String password, String role){
        this.username=username;
        this.password=password;
        this.role=role;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
