package com.practice.proxy.parameter;

import java.util.Collection;

public class DataHolderTest {


    <T extends Comparable<T>> void consume(@PrintMaxValue Collection<T> collection) {
        collection.forEach(System.out::println);
    }
}
