package com.activemq.demo;

import com.sendMessage.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    SmsService sms;

    public void smsSend(String phone,String VTime){
        sms.smsSend(phone,VTime);
    }

}
