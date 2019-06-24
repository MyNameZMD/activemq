package com.activemq.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpringTask {
    private int count=0;
    @Autowired
    Nio nio;
    @Scheduled(cron = "*/5 * * * * *")
    public void pro() throws IOException {
        if(count++%2==0){
            nio.write();
        }else{
            nio.read();
        }
    }
}
