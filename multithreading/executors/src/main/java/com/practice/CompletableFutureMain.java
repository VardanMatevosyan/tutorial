package com.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;

public class CompletableFutureMain {

  public static void main(String[] args) throws Exception {
    testCFSupplyAsync();
    testCFRunAsync();
    testSubmitRunnable();
  }

  private static void testCFSupplyAsync() throws Exception {
    System.out.println("--- testCFSupplyAsync");
    System.out.println();
    CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenAcceptAsync(str -> System.out.println("Result " + str));
    Thread.sleep(10L); // because of thenAcceptAsync if thenAccept used then no need to sleep
  }

  private static void testCFRunAsync() throws Exception {
    System.out.println();
    System.out.println("--- testCFRunAsync");
    System.out.println();
    CompletableFuture<Void> strCF = CompletableFuture
            .runAsync(() -> System.out.println("Hello"));
    Thread.sleep(10L);
    System.out.println("Is done " + strCF.isDone());
    System.out.println("Is cancelled " + strCF.isCancelled());
    System.out.println("Is completedExceptionally " + strCF.isCompletedExceptionally());
  }

  private static void testSubmitRunnable() {
    System.out.println();
    System.out.println("--- testSubmitRunnable");
    System.out.println();
    System.out.println("Starting to run Runnable tasks");
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(newRunnable("1-runnable"));
    executorService.submit(newRunnable("2-runnable"));
    executorService.submit(newCallable("3-callable in Submit method will be executed by one of the 2 threads in the pool"));
    System.out.println();
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
