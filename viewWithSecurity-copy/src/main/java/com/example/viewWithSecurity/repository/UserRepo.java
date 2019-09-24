package com.example.viewWithSecurity.repository;

import com.example.viewWithSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {

    List<User> findByName(String name);

}
