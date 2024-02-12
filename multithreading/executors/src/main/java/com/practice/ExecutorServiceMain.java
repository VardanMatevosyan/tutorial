package com.practice;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {

  public static void main(String[] args) {
    testSubmitRunnable();
    testSubmitThreadPoolExecutor();
    testInvokeAllCallable();
  }

  private static void testSubmitRunnable() {
    System.out.println("Starting to run Runnable tasks");
    ExecutorService executorService = Executors.newFixedThreadPool(2);;
    executorService.submit(newRunnable("1-runnable"));
    executorService.submit(newRunnable("2-runnable"));
    executorService.submit(newCallable("3-callable in Submit method will be executed by one of the 2 threads in the pool"));
    System.out.println();
    executorService.shutdown();
  }

  private static void testSubmitThreadPoolExecutor() {
    System.out.println("Starting to run Runnable tasks");
    ExecutorService executorService = new ThreadPoolExecutor(
        2,
        2,
        5000L,
        TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<>(3));

    executorService.submit(newRunnable("1-runnable-thread-pool-executor"));
    executorService.submit(newRunnable("2-runnable-thread-pool-executor"));
    executorService.submit(newCallable("3-callable-thread-pool-executor in Submit method will be executed by one of the 2 threads in the pool"));
    System.out.println();
    executorService.shutdown();
  }

  private static void testInvokeAllCallable() {
    System.out.println("Starting to run Callable tasks");
    ExecutorService executorService = Executors.newFixedThreadPool(2);;
    List<Callable<String>> callables = List.of(newCallable("1-callable"), newCallable("2-callable"));

    try {
      List<Future<String>> futures = executorService.invokeAll(callables);

      for (Future<String> future : futures) {
        String s = future.get();
        System.out.println("result of the execution is " + s);
      }
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("can't execute the callable task and get the result");
    }


    executorService.shutdown();
  }

  private static Runnable newRunnable(String s) {
    return () -> {
      String threadMsg =
          " group = " + Thread.currentThread().getThreadGroup()
              + " name = " + Thread.currentThread().getName()
              + " message = " + s;
      System.out.println(threadMsg);
    };
  }

  private static Callable<String> newCallable(String s) {
    return () -> {
      String threadMsg =
          " group = " + Thread.currentThread().getThreadGroup()
          + " name = " + Thread.currentThread().getName()
          + " message = " + s;
      System.out.println(threadMsg);
      return threadMsg;
    };
  }


}
