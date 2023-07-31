package com.practice;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Admin on 15.11.2017.
 */
public class ProducerExchanger extends Thread {
    private Exchanger<CopyOnWriteArrayList<Integer>> exchanger;
    private CopyOnWriteArrayList<Integer> buff = new CopyOnWriteArrayList<>();
    private static final int SIZE_EXIT_VALUE = 2;

    public ProducerExchanger(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (this.buff.size() < SIZE_EXIT_VALUE) {
            try {
                System.out.println("Welcome to Producer");
                Thread.sleep(100);
                this.buff.add(123456);
                this.buff.add(78910);
                System.out.println("Producer add 2 numbers" + this.buff);
                this.exchanger.exchange(this.buff);
            } catch (InterruptedException ie) {
                System.out.println("Something goes wrong...");
            }
        }
    }
}
