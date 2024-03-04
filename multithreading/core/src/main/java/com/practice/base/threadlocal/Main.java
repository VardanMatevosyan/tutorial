package com.practice.base.threadlocal;

import com.practice.base.threadlocal.service.LoggingServiceImpl;
import java.util.concurrent.CompletableFuture;

public class Main {

  private static final LoggingServiceImpl loggingService = new LoggingServiceImpl();

  public static void main(String[] args) {

    CompletableFuture<Void> cf1 = CompletableFuture.runAsync(runnableLogging());
    CompletableFuture<Void> cf2 = CompletableFuture.runAsync(runnableLogging());

    CompletableFuture.allOf(cf1, cf2).join();

  }

  private static Runnable runnableLogging() {
    return () -> {
      imitateSessionContextManagerFilter();
      serviceBusinesslikeLogging();
    };
  }

  private static void imitateSessionContextManagerFilter() {
    SessionContextManager sessionContextManager = new SessionContextManager();
    sessionContextManager.setSessionId();
  }

  private static void serviceBusinesslikeLogging() {
    loggingService.log();
  }

}
