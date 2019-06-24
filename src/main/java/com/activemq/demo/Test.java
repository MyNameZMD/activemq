package com.activemq.demo;

public class Test {
    public static void main(String[] args) {
        String str="|abc|de";
        System.out.println(str.split("").length);
        System.out.println(str.split("\\|").length);
    }
}
