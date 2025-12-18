package com.project.TodosApplication.security;

//import org.springframework.cglib.core.internal.Function;
import com.project.TodosApplication.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){ //Password encoder
        return new BCryptPasswordEncoder();
    }
    // Authentication manager (required for login + auto-login)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    public String getLoggedInUserName(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login",
                                "/signup",
                                "/css/**",
                                "/webjars/**",
                                "/WEB-INF/jsp/**") //allow only these URLs before/without authentication, and css-webjars to load static content
                        .permitAll() //permit the above url types
                        .anyRequest().authenticated()
                )
                .formLogin(form->form
                        .loginPage("/login") //specify path to custom login page
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/welcome", true)
                        .failureUrl("/login?error=true")
                        .permitAll() // Allow everyone to view the login page
                )
                .logout(logout->logout.logoutSuccessUrl("/login?logout=true")) // Allow everyone to logout
                .csrf(csrf -> csrf.disable());
//                .headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
}

