package com.practice.base;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitNotifyProducerConsumer {
  private static final Queue<String> QUEUE = new ConcurrentLinkedQueue<>();

  public static void main(String[] args) throws InterruptedException {

    Producer producer = new Producer("s1s");
    Producer producer2 = new Producer("s2s");
    Producer producer3 = new Producer("s3s");

    Consumer consumer = new Consumer();
    Consumer consumer2 = new Consumer();
    Consumer consumer3 = new Consumer();
    Consumer consumer4 = new Consumer();
    Consumer consumer5 = new Consumer();


    consumer.start();
    consumer2.start();
    consumer3.start();
    consumer4.start();
    consumer5.start();
    Thread.sleep(2000);
    producer.start();
    producer2.start();
    producer3.start();

    producer.join();
    producer2.join();
    producer3.join();
    consumer.join();
    consumer2.join();
    consumer3.join();
    consumer4.join();
    consumer5.join();


  }

  static class Producer extends Thread {
    final String item;

    Producer(String item) {
      this.item = item;
    }

    @Override
    public void run() {
      System.out.println("producer "  + Thread.currentThread().getName() + "- Step in to  ");
      synchronized (QUEUE) {
        while (QUEUE.size() == 5) {
          try {
            System.out.println("producer "  + Thread.currentThread().getName() + " - before wait  ");
            QUEUE.wait();
            System.out.println("producer "  + Thread.currentThread().getName() + " - after wait  ");
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        if (QUEUE.size() < 5) {
          System.out.println("producer "  + Thread.currentThread().getName() + " - Produced " + item);
          QUEUE.add(item);
          System.out.println("producer "   + Thread.currentThread().getName() +  " - before notify  ");
          QUEUE.notifyAll();
          System.out.println("producer "  + Thread.currentThread().getName() + " - after notify  ");
        }

        System.out.println();
      }
    }
  }


  static class Consumer extends Thread {

    Consumer() {
    }

    @Override
    public void run() {
      System.out.println("consumer" + Thread.currentThread().getName() + " Step in to ");
      synchronized (QUEUE) {
        while (QUEUE.isEmpty()) {
          try {
            System.out.println("consumer "  + Thread.currentThread().getName() + " - before wait  ");
            QUEUE.wait();
            System.out.println("consumer "  + Thread.currentThread().getName() + " - after wait  ");
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }

        if (QUEUE.size() >= 1) {
          String s = QUEUE.poll();
          System.out.println("consumer Consumed " + s + " from thread " + Thread.currentThread().getName());

          System.out.println("consumer "  + Thread.currentThread().getName() + " - before notify  ");
          QUEUE.notifyAll();
          System.out.println("consumer "  + Thread.currentThread().getName() + " - after notify  ");
        }

        System.out.println();
      }
    }
  }

}