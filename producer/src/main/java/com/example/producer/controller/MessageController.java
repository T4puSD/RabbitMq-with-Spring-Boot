package com.example.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/message/{msg}")
    public void sendMessage(@PathVariable(name = "msg") String msg){
        System.out.println("Sending message:" + msg);
        rabbitTemplate.convertAndSend(msg);
    }


}
