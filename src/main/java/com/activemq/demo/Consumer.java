package com.activemq.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "consumer")
    public void receiveQueue(String text){
        System.out.println("Consumer操作："+text);
    }
}
