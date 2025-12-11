package com.project.TodosApplication.security;

//import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class SpringSecurityConfig {
    //Use LDAP or Database
    //Using here In memory database

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails ud1=createNewUser("ADMIN","Dummy","ADMIN");
        UserDetails ud2=createNewUser("Eric","Dummy","USER");
        UserDetails ud3=createNewUser("Casey","Dummy","USER");
        UserDetails ud4=createNewUser("Amanda","Dummy","USER");
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
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login", "/css/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")        // your custom login page
//                        .loginProcessingUrl("/login") // form POST URL
//                        .defaultSuccessUrl("/welcome", true)
//                        .failureUrl("/login?error=true")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login?logout=true")
//                        .permitAll()
//                );
//
//        return http.build();
//    }
}
