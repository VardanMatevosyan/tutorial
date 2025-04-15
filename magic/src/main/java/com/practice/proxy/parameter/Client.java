package com.practice.proxy.parameter;

import java.util.Arrays;
import java.util.Collection;

public class Client {
    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(3, 5, 7, 3, 7777);
        DataHolderTest dataHolderTest = ProxyDataHolderTest.getProxy(DataHolderTest.class);
        dataHolderTest.consume(collection);
    }
}
