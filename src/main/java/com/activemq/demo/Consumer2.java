package com.activemq.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
    @JmsListener(destination = "consumer2")
    public void receiveQueue(String text){
        System.out.println("Consumer2操作："+text);
    }
}
