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
        Function<String, String> passwordEncoder= input-> passwordEncoder().encode(input);
        UserDetails userDetails= User.builder().
                passwordEncoder(passwordEncoder).
                username("admin").
                password("dummy").
                roles("USER","ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public String getLoggedInUserName(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
