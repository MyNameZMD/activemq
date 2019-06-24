package com.activemq.demo;

import org.apache.ibatis.annotations.Mapper;


public interface SmsService {
    public void smsSend(String phone, String VTime);
}
