package com.project.TodosApplication.signupController;

import com.project.TodosApplication.user.User;
import com.project.TodosApplication.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public SignUpController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String toSignUpPage(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@ModelAttribute User user){
        String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword)); //storing encoded password: BCrypt hash to DB
        user.setRole("ROLE_USER"); //assigning default role to user

        userRepository.save(user); //inserts a new user in DB
        //Create Authentication token for auto login
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), rawPassword);
        //Authenticate user
        Authentication authentication = authenticationManager.authenticate(authToken); //invokes loadUserByUsername(String username) from CustomUserDetailsService
        //Stores authenticatio object to Security->Marks user as logged in->Stores authentication in session
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/welcome";
    }
}
