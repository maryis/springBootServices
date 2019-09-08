package com.example.controller;


import com.example.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Slf4j
public class KafkaProducer {


    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test";


    //http://localhost:6060/publish?msg=dzfsfdvfg
    @PostMapping(path = "/publish")
    public void sendMessToTopic(@RequestParam("msg") String msg) {

        System.out.println(msg);
        kafkaTemplate.send(TOPIC,msg);


    }


}
