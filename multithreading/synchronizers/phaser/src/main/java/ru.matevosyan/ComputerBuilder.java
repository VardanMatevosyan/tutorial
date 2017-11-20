package ru.matevosyan;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;

/**
 * Created by Admin on 16.11.2017.
 */
public class ComputerBuilder {
    private Phaser phaser;
    private CopyOnWriteArrayList<String> action;
    private ComputerPhase computerPhase;

    public ComputerBuilder(Phaser phaser, CopyOnWriteArrayList<String> action) {
        this.phaser = phaser;
        this.action = action;
    }

    public void build() {
        int i = 0;
        while (this.phaser.getPhase() < 3 && i < 3) {
            this.computerPhase = new ComputerPhase(phaser, action.get(i++));
            this.computerPhase.start();
        }

        try {
            this.computerPhase.join();
                Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
