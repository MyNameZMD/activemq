package com.activemq.demo;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("169.254.26.130", 6379);

        // 保存String
        jedis.set("keyStr", "valueStr");
        String str = jedis.get("keyStr");
        System.out.println("key值为keyStr的value值为：" + str);

        // 保存list到redis
        jedis.lpush("javalist", "111");
        jedis.lpush("javalist", "222");
        jedis.lpush("javalist", "333");
        jedis.lpush("javalist", "444");
        jedis.lpush("javalist", "555");

        // 获取list
        List<String> lrange = jedis.lrange("javalist", 0, -1);
        for (String string : lrange) {
            System.out.println(string);
        }

        // 保存set
        jedis.sadd("javaset", "set1", "set2", "set3", "set4", "set5");
        Set<String> sets = jedis.smembers("javaset");
        for (String string : sets) {
            System.out.println(string);
        }
    }
}
