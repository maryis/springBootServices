package com.example.viewWithSecurity.controller;

import com.example.viewWithSecurity.entity.User;
import com.example.viewWithSecurity.service.SecurityService;
import com.example.viewWithSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping({"/", "/welcome"})
    public String home() {
        System.out.printf("home get");

        return "welcome";
    }

    @GetMapping("/noAccess")
    public String noAccess() {
        System.out.printf("no access ");

        return "accessDenied";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        System.out.printf("register get");

        return "registration";
    }

    @PostMapping("/register")
    public String registerPage(@RequestBody User user) {

        System.out.printf("register post");

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

    @GetMapping("/error")
    public String error() {
        System.out.printf("error get");
        return "welcome";
    }
}
