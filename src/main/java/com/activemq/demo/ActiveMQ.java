package com.activemq.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class ActiveMQ {
    @Autowired
    private Producer producer;
    public void contextLoads(String name,String str){
        Destination destination = new ActiveMQQueue(name);
        producer.sendMessage(destination, str);
    }
}
