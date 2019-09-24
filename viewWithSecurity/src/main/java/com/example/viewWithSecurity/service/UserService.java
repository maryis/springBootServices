package com.example.viewWithSecurity.service;

import com.example.viewWithSecurity.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
