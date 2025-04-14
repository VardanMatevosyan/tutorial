package com.practice.proxy.v1_interface;

public class Client {


    public static void main(String[] args) {
        problem();
        solution();
    }

    private static void solution() {
        ServiceA serviceA = new ProxyServiceA();
        serviceA.convert();
    }

    private static void problem() {
        ServiceA serviceA = new ServiceAImpl();
        System.out.println("log convert");
        serviceA.convert();
    }
}
