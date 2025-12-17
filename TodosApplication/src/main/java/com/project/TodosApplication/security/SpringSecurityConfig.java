package com.project.TodosApplication.security;

//import org.springframework.cglib.core.internal.Function;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    //Use LDAP or Database
    //Using here In memory database

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails ud1=createNewUser("admin","dummy","ADMIN");
        UserDetails ud2=createNewUser("Eric","dummy","USER");
        UserDetails ud3=createNewUser("Casey","dummy","USER");
        UserDetails ud4=createNewUser("Amanda","dummy","USER");
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

