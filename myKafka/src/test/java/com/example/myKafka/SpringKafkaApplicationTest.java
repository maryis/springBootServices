package com.example.myKafka;


import com.example.controller.KafkaConsumer;
import com.example.controller.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1,
        topics = {"test"})
public class  SpringKafkaApplicationTest {

    String HELLOWORLD_TOPIC="test";

    @Autowired
    private KafkaConsumer receiver;

    @Autowired
    private KafkaProducer sender;

    @Test
    public void testSend() throws Exception {
        sender.send(HELLOWORLD_TOPIC, "Hello Spring Kafka!");

    }
}
