package com.project.TodosApplication.security;

//import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfig {
    //Use LDAP or Database
    //Using here In memory database

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails ud1=createNewUser("ADMIN","Dummy","ADMIN");
        UserDetails ud2=createNewUser("Eric","Dummy","USER");
        UserDetails ud3=createNewUser("Casey","Dummy","USER");
        return new InMemoryUserDetailsManager(ud1, ud2, ud3);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public String getLoggedInUserName(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    private UserDetails createNewUser(String username, String password, String role){
        Function<String, String> passwordEncoder= input-> passwordEncoder().encode(input);
        UserDetails userDetails= User.builder().
                passwordEncoder(passwordEncoder).
                username(username).
                password(password).
                roles(role).
                build();
        return userDetails;
    }
}
