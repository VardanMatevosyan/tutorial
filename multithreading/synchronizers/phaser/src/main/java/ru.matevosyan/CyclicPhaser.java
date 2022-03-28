package ru.matevosyan;

import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Created by Admin on 18.11.2017.
 */
public class CyclicPhaser {

    public CyclicPhaser() {
    }

    public void runTask(final List<Runnable> tasks, final int iterates) {
        Thread thread = new Thread();
        final Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int parties) {
                return phase >= iterates || parties == 0;
            }
        };
        System.out.println("before Main Register parties is = " + phaser.getRegisteredParties());
        phaser.register();
        System.out.println("Main Register parties is = " + phaser.getRegisteredParties());
        System.out.println("Phase is - " + phaser.getPhase());
        for (final Runnable task : tasks) {

            phaser.register();
            System.out.println("Register parties is = " + phaser.getRegisteredParties());
            thread = new Thread() {
                public void run() {
                    do {
                        System.out.println("run");
                        task.run();
                        System.out.println("wait for advance");
                        System.out.println("Phase is - " + phaser.getPhase());
                        System.out.println("Register parties is = " + phaser.getRegisteredParties());
                        phaser.arriveAndAwaitAdvance();
                    } while (!phaser.isTerminated());
                }
            };

            thread.start();
        }
        System.out.println("before dereg Register parties is = " + phaser.getRegisteredParties());
        phaser.arriveAndDeregister();
        System.out.println("after dereg Register parties is = " + phaser.getRegisteredParties());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phase is - " + phaser.getPhase());
    }
}
