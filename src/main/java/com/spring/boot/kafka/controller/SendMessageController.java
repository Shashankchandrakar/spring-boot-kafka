package com.spring.boot.kafka.controller;

import com.spring.boot.kafka.Message;
import com.spring.boot.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SendMessageController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public SendMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @RequestMapping("/")
    @PostMapping
    public void sendMessage(@RequestBody Message message){
        kafkaProducer.sendMessage(message.getMessage());
    }
}
