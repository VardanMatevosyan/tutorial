package com.practice;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Admin on 15.11.2017.
 */
public class ConsumerExchangerTest {
    private Exchanger<CopyOnWriteArrayList<Integer>> exchanger = new Exchanger<>();
    private ProducerExchanger producerExchanger = new ProducerExchanger(exchanger);
    private ConsumerExchanger consumerExchanger = new ConsumerExchanger(exchanger);

    @Test
    public void whenProducerAddThanConsumerGet() {
        producerExchanger.start();
        consumerExchanger.start();

        try {
            producerExchanger.join();
            consumerExchanger.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}