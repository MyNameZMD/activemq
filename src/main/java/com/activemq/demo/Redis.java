package com.activemq.demo;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class Redis {
    Jedis jedis = new Jedis("169.254.26.130", 6379);
    public String readWrite(String key){
        jedis.set("keyStr", "valueStr");
        return jedis.get(key);
    }
    public void pushList(String key,String value){
        jedis.lpush(key, value);
    }
}
