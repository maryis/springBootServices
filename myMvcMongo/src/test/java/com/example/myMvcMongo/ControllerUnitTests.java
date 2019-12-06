package com.example.myMvcMongo;

import com.example.controller.UserController;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)

@SpringBootTest
@AutoConfigureMockMvc  //this two lines are good for integration test, because initial complete application context
//or instead of two lines
//@WebMvcTest(UserController.class)//: it is good for unit test of web layer, when there is no dep to button layers

public class ControllerUnitTests {

    @MockBean  //We can use the @MockBean to add mock objects to the Spring application context.
    // The mock will replace any existing bean of the same type in the application context. it is useful for integration test
    private UserRepository userRepository;

    //or

//    @Mock //create a mock object of a class or an interface.
    //note that when we want to mock an inside class which is not called explicitly(like here),
    //using this mock does not help, because the bean that is injected in context should be mocked
//    private UserRepository userRepository;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callGet() throws Exception {
        BigInteger id = new BigInteger("5");

        List<User> list = Arrays.asList(new User(id, "ali66", "hello"));

        when(userRepository.findAll()).thenReturn(list);

        mockMvc.perform(get("/get"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("ali66")));

    }

    @Test
    public void call_post() throws Exception {

        BigInteger id = new BigInteger("51");
        User user = new User(id, "reza1", "rahmani1");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("reza1")));

    }

}
