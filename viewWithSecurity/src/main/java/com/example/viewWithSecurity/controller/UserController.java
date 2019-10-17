package com.example.viewWithSecurity.controller;

import com.example.viewWithSecurity.entity.User;
import com.example.viewWithSecurity.exception.UserExistException;
import com.example.viewWithSecurity.exception.UserInfoIncorrectException;
import com.example.viewWithSecurity.exception.UserNotFoundException;
import com.example.viewWithSecurity.service.SecurityService;
import com.example.viewWithSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

//    // Convert a predefined exception to an HTTP Status code :optional
//    @ResponseStatus(value= HttpStatus.CONFLICT,reason="Data integrity violation")  // 409
//    @ExceptionHandler(UserNotFoundException.class)
//    public ModelAndView handleException(UserNotFoundException ex) {
//        //Do something additional if required
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("message", ex.getMessage());
//        return modelAndView;
//    }

    @GetMapping({"/", "/welcome"})
    public String home() {

        return "welcome";
    }

    @GetMapping("/error")
    public String noAccess() {
        return "error";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "registration";
    }
    @GetMapping("/chechexc")
    public String chechExceptionHanding() {
        throw new UserNotFoundException("to check exception handler");
    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute User user) throws UserInfoIncorrectException, UserExistException {//it gets data from form-data

        if(user.getUsername()==""||user.getPassword()==""||user.getPassConfirm()=="")
            throw new UserInfoIncorrectException("Please Enter Data");

        if(!user.getPassConfirm().equals(user.getPassword()))
            throw new UserInfoIncorrectException("pass and its confirm are not the same");

        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/welcome";
    }

    //We don't define /login POST controller, it is provided by Spring Security!!!!!!!!!!!!!s
    @GetMapping("/login")
    public String login() {
        System.out.printf("login get");
        return "login";
    }

}
