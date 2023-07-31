package com.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * FutureTaskExample class.
 * Created on 05.11.2017.
 * @author Matevosian Vardan
 * @param <T> type.
 * @version 1.0
 */

public class ExecutorExample<T> implements Callable<T> {
    private ExecutorService executorService;
    private List<Future<T>> listOfFuture;

    public ExecutorExample(int initThreadPool) {
        this.executorService = Executors.newFixedThreadPool(initThreadPool);
        this.listOfFuture = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T call() {
        return (T) Thread.currentThread().getName();
    }

    public void executeTaskAndFillListOfFuture(ExecutorExample<T> callableTask) {
        Future<T> futureResult = this.executorService.submit(callableTask);
        this.listOfFuture.add(futureResult);
    }

    public void shutDownExecution() {
        this.executorService.shutdown();
    }

    public void outPutAllTaskName() {
        this.listOfFuture.forEach(value -> {
            try {
                System.out.println(new Date() + "::" + value.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}
