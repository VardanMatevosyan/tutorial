package ru.matevosyan;

import java.util.concurrent.Phaser;

/**
 * Created by Admin on 16.11.2017.
 */
public class ComputerPhase extends Thread {
    private final Phaser computerBuildPhase;
    private final String concretePhase;

    public ComputerPhase(Phaser computerBuildPhase, String concretePhase) {
        this.computerBuildPhase = computerBuildPhase;
        this.concretePhase = concretePhase;
//        computerBuildPhase.register();
    }

    @Override
    public void run() {
        while (computerBuildPhase.getPhase() < 3) {
            System.out.println(this.concretePhase + " running computer phase " + this.computerBuildPhase.getPhase());
            this.computerBuildPhase.arriveAndAwaitAdvance();
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
