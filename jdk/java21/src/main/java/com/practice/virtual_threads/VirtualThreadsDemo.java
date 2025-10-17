package com.practice.virtual_threads;

/**
 * VirtualThreadsDemo demonstrates the use of virtual threads in Java.
 * Virtual threads are lightweight threads that are managed by the Java runtime,
 * allowing for a large number of concurrent threads with minimal resource overhead.
 *
 * In future LTS versions, virtual threads will be the default implementation for threads.
 *
 * Note: Virtual threads are available in Java 21 and later versions.
 */
public class VirtualThreadsDemo {
  public static void main(String[] args) throws InterruptedException {
    Thread virtualThread = Thread.ofVirtual().start(getTask("Virtual Thread"));
    virtualThread.join();
  }

  private static Runnable getTask(String virtualThread) {
    return () -> {
      System.out.println(virtualThread + " running...");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        System.out.println(virtualThread + " finished.");
      }
    };
  }

}
