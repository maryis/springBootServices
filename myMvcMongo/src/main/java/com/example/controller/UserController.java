package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
//it is better to obey rest path conventions
@RequestMapping("/users")
public class UserController implements ErrorController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> getById(@PathVariable BigInteger id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/getTopByName")
    public User getByName(@RequestParam String name) {
        return userRepository.findTopByName();
    }

    @Override
    public String getErrorPath() {
        return "/get";
    }
}
