package com.activemq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Component
public class Nio {
    @Autowired
    Redis redis;
    @Autowired
    private ActiveMQ activeMQ;
    public void write() throws IOException {
        activeMQ.contextLoads("consumer","写入");
        String str=redis.readWrite("keyStr");
        File file = new File("f:\\test.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = str;
        buffer.put(string.getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
        outputStream.close();
    }
    public void read() throws IOException{
        activeMQ.contextLoads("consumer2","读取");
        FileInputStream fin = new FileInputStream("f:\\test.txt");
        FileChannel fc=fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        StringBuffer sb=new StringBuffer();
        while (buffer.remaining() > 0 ){
            byte b = buffer.get();
            sb.append((char)b);
        }
        System.out.println(sb);
        fin.close();
        redis.pushList("javaList",sb.toString());
    }
}
