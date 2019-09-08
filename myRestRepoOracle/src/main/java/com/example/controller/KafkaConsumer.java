package com.example.controller;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaConsumer {

    @KafkaListener(topics = "test")
    public void persistMsg(String msg){
        System.out.println(msg);
    }



}
