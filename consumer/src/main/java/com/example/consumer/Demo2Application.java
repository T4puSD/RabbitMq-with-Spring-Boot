package com.example.consumer;

import com.example.consumer.storage.MessageList;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {
    private MessageList messageList;
    private static final String ROUTING_KEY = "myQueue";

    @Autowired
    public Demo2Application(MessageList messageList) {
        this.messageList = messageList;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }


    @RabbitListener(queues = ROUTING_KEY)
    public void listen(String in){
        messageList.appendMessage(in);
    }
}
