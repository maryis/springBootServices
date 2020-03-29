package com.example.controller;


import com.example.entity.Log;
import com.example.repository.LogRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.util.Date;


@Controller
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    LogRepository logRepository;

    @KafkaListener(topics = "${kafka.topic.boot}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.toString());
        logRepository.save(new Log(2,consumerRecord.toString(),new Date()));

    }


}
