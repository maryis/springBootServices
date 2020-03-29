package com.example.myMvcMongo;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Optional;


//it is not completed
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class RepoIntegrationTest2 {


    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){

        BigInteger b=new BigInteger("33");
        User u=new User(b,"zsd","asdfsf");
        userRepository.save(u);
    }
    @Test

    public void testFind(){
        BigInteger b=new BigInteger("33");

        Optional<User> u=userRepository.findById(b);

        Assert.assertEquals("find user by is ",u.get().getName(),"zsd");

    }

}

