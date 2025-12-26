package com.project.TodosApplication.signupController;

import com.project.TodosApplication.dto.SignUpDTO;
import com.project.TodosApplication.user.User;
import com.project.TodosApplication.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("signup",new SignUpDTO());
        return "signup";
    }
    @RequestMapping(value = "/signup", method=RequestMethod.POST)
    public String signUp(@Valid @ModelAttribute("signup") SignUpDTO signUpDTO,  BindingResult result, HttpServletRequest request){ //all input field from UI(View) are mapped to SignUpDTO
        if(result.hasErrors())
        {
            return "signup";
        }

        User newUser =new User();
        newUser.setUsername(signUpDTO.getUsername());
        newUser.setEmail(signUpDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword())); //storing encoded password: BCrypt hash to DB
        newUser.setRole("ROLE_USER"); //assigning default role to user

        userRepository.save(newUser); //inserts a new user in DB
        //Create Authentication token for auto login
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(signUpDTO.getUsername(), signUpDTO.getPassword());
        //Authenticate user
        Authentication authentication = authenticationManager.authenticate(authToken); //invokes loadUserByUsername(String username) from CustomUserDetailsService

        //Stores authentication object to Security->Marks user as logged in
        SecurityContext securityContext=SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        //Stores authentication in session
        HttpSession session=request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,securityContext);
        return "redirect:/welcome";
    }
}
