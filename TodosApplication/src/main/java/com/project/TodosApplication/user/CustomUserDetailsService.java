package com.project.TodosApplication.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    //the heart of DB-based authentication in Spring Security
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException //Spring Security passes the login username here
    {
        User user=userRepository.findByUsername(username) //fetch the User from DB
                .orElseThrow(()->new UsernameNotFoundException("User not found"+username)); //not found-> throw User not found exception->redirect to: login?error=true
        return new org.springframework.security.core.userdetails.User( //convert DB user to Spring security user
                user.getUsername(), //fetching the username from DB
                user.getPassword(), //fetching the password(Encoded) from DB
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())) //Convert the Role -> Granted Authority
        );
    }
}
