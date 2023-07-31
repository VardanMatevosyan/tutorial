package com.practice;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Created by Admin on 10.11.2017.
 */
public class FutureTaskExampleTest {
    private FutureTaskExample futureTaskExample1 = new FutureTaskExample(1000);
    private FutureTaskExample futureTaskExample2 = new FutureTaskExample(2000);

    //2 Future task for 2 callable instances.
    private FutureTask<String> futureTask1 = new FutureTask<>(futureTaskExample1);
    private FutureTask<String> futureTask2 = new FutureTask<>(futureTaskExample2);

    //executor with size of 2
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    @Test
    public void whenStartExecutorThanCheckOutPut() {
        //starting
        this.executor.execute(this.futureTask1);
        this.executor.execute(this.futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Done");
                    //finishing the executors work
                    executor.shutdown();
                    return;
                }

                if (!futureTask1.isDone()) {
                    //wait until futureTask1 is done.
                    System.out.println("Results of execution futureTask1 " + futureTask1.get());
                }

                System.out.println("Results of execution futureTask2 ");
                String s = futureTask2.get(2000L, TimeUnit.MILLISECONDS);

                if (s != null) {
                    System.out.println("Results of execution futureTask2 " + s);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Get Time OUT Exception waiting for data ");
            }
        }

    }
 }
