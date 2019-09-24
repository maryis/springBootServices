package com.example.viewWithSecurity.controller;

import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
//
////    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/")
//    public String home(HttpServletRequest request) {
//        System.out.println(request.getRequestURL());
//
//        System.out.println("call home");
//        return "home";
//    }
//
//    @GetMapping("/pub/logout")
//    public String logout(HttpServletRequest request) {
//        //
//        System.out.println(request.getRequestURL());
//
//        System.out.println("call logout");
//
//        return "public/logout";
//    }
//
//    @GetMapping("/login")
//    public String login(HttpServletRequest request) {
//        //
//        System.out.println(request.getRequestURL());
//        System.out.println("call login");
//
//        return "login";
//    }
//    @GetMapping("/pub/error")
//    public String publics(HttpServletRequest request) {
//        //
//        System.out.println(request.getRequestURL());
//
//        System.out.println("call public");
//
//        return "public/withoutAuth";
//    }
}
