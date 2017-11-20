package ru.matevosyan;

import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Created by Admin on 18.11.2017.
 */
public class RunTasks {
    public RunTasks() {
    }
    public void runTask(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1);

        for (final Runnable task : tasks) {
            phaser.register();
            Thread thread = new Thread() {
               public void run() {
                   System.out.println("wait for advance");
                   phaser.arriveAndAwaitAdvance();
                   System.out.println("run");
                   task.run();

               }
            };

            thread.start();

            phaser.arriveAndDeregister();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


        System.out.println("Phase count - " + phaser.getPhase());
    }
}
