package com.activemq.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2Test {

    @Autowired
    private Producer producer;
    @Test
    public void contextLoads() {
        Destination destination = new ActiveMQQueue("mytest.queue");
        producer.sendMessage(destination, "myname is chhliu!!!");
    }
}