package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements ErrorController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<User>  getAll(){
        return userRepository.findAll();
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@RequestBody User user){
        return userRepository.save(user);
        //return userRepository.findTopById();
    }


    @Override
    public String getErrorPath() {
        return "/get";
    }
}
