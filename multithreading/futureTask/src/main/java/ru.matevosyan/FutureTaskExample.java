package ru.matevosyan;

import java.util.concurrent.Callable;

/**
 * FutureTaskExample class.
 * Created on 05.11.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class FutureTaskExample implements Callable<String> {
    private long waitTimeMillis;

    public FutureTaskExample(int timeToWait) {
        this.waitTimeMillis = timeToWait;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(this.waitTimeMillis);
        return Thread.currentThread().getName();
    }
}
