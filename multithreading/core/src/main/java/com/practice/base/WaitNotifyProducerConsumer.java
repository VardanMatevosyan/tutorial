package com.practice.base;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyProducerConsumer {

  public static void main(String[] args) throws InterruptedException {
    List<String> list = new ArrayList<>();

    Producer producer = new Producer(list, "s1s");
    Producer producer2 = new Producer(list, "s2s");
    Producer producer3 = new Producer(list, "s3s");

    Consumer consumer = new Consumer(list, 0);
    Consumer consumer2 = new Consumer(list, 1);
    Consumer consumer3 = new Consumer(list, 2);
    Consumer consumer4 = new Consumer(list, 2);
    Consumer consumer5 = new Consumer(list, 2);


    consumer.start();
    consumer2.start();
    consumer3.start();
    consumer4.start();
    consumer5.start();
    Thread.sleep(5000);
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
    final List<String> list;
    final String item;


    Producer(List<String> list, String item) {
      this.list = list;
      this.item = item;
    }

    @Override
    public void run() {
      System.out.println("producer "  + Thread.currentThread().getName() + "- Step in to  ");
      synchronized (list) {
        while (list.size() == 5) {
          try {
            System.out.println("producer "  + Thread.currentThread().getName() + " - before wait  ");
            list.wait();
            System.out.println("producer "  + Thread.currentThread().getName() + " - after wait  ");
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        if (list.isEmpty()) {
          System.out.println("producer "   + Thread.currentThread().getName() +  " - before notify  ");
          list.notifyAll();
          System.out.println("producer "  + Thread.currentThread().getName() + " - after notify  ");
        }
        System.out.println("producer "  + Thread.currentThread().getName() + " - Produced " + item);
        list.add(item);
        System.out.println();
      }
    }
  }


  static class Consumer extends Thread {
    final List<String> list;
    final int index;

    Consumer(List<String> list, int index) {
      this.list = list;
      this.index = index;
    }

    @Override
    public void run() {
      System.out.println("consumer" + Thread.currentThread().getName() +" Step in to ");
      synchronized (list) {
        while (list.isEmpty()) {
          try {
            System.out.println("consumer "  + Thread.currentThread().getName() + " - before wait  ");
            list.wait();
            System.out.println("consumer "  + Thread.currentThread().getName() + " - after wait  ");
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }

        if (list.size() > index) {
          String s = list.get(index);
          System.out.println("consumer Consumed " + s + " from thread " + Thread.currentThread().getName());
        }

        if (list.size() == 5) {
          System.out.println("consumer "  + Thread.currentThread().getName() + " - before notify  ");
          list.notifyAll();
          System.out.println("consumer "  + Thread.currentThread().getName() + " - after notify  ");
        }

        System.out.println();
      }
    }
  }

}

