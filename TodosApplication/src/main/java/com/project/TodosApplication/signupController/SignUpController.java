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
import org.springframework.ui.ModelMap;
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
    public String toSignUpPage(){
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@RequestParam String username, String email, String password, ModelMap model, User user, HttpServletRequest request){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        // 2️⃣ Save user to DB
        userRepository.save(user);

        // 3️⃣ Auto-login after signup
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        request.getParameter("password") // raw password
                );
        Authentication authentication =
                authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/welcome";
    }
}
