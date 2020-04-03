package com.example.repository;

import com.example.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {

    User findTopByName();

}
