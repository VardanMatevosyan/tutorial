package com.practice.proxy.method;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ClassTest proxy = ProxyClassTest.getProxy(SomeClassTest.class);
        proxy.test();
    }
}
