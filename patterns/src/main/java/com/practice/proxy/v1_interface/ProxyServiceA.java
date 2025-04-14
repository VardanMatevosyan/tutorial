package com.practice.proxy.v1_interface;

public class ProxyServiceA implements ServiceA {

    ServiceA service = new ServiceAImpl();
    @Override
    public void convert() {
        System.out.println("log convert");
        service.convert();
    }
}
