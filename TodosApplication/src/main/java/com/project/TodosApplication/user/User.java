package com.project.TodosApplication.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")  //custom name for table in todosDB
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
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

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
