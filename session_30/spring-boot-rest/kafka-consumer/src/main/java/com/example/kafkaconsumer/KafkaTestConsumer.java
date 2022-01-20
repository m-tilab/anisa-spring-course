package com.example.kafkaconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaTestConsumer {

    @KafkaListener(topics = "test")
    public void receiveMessage(String value) {

        log.info("Received message: " + value);


    }
}
