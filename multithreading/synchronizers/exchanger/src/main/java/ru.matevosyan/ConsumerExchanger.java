package ru.matevosyan;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Admin on 15.11.2017.
 */
public class ConsumerExchanger extends Thread {
    private Exchanger<CopyOnWriteArrayList<Integer>> exchanger;
    private CopyOnWriteArrayList<Integer> buff = new CopyOnWriteArrayList<>();
    private static final int SIZE_EXIT_VALUE = 2;

    public ConsumerExchanger(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Welcome to Consumer");
                this.buff = this.exchanger.exchange(this.buff);
                System.out.println("Consumer get 2 numbers" + this.buff);
                Thread.sleep(100);
                this.buff.clear();
                System.out.println("Consumer clear the data" + this.buff);

                if (this.buff.size() <= SIZE_EXIT_VALUE) {
                    break;
                }
            } catch (InterruptedException ie) {
                System.out.println("Something goes wrong...");
            }
        }
    }
}
