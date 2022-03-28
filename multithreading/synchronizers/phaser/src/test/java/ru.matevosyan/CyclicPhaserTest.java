package ru.matevosyan;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Admin on 18.11.2017.
 */
public class CyclicPhaserTest {
    private final CyclicPhaser cyclicPhaser = new CyclicPhaser();
    @Test
    public void whenThan() {
        CopyOnWriteArrayList<Runnable> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 3; i++) {
            int k = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("runnable task" + k);
                }
            };

            list.add(runnable);
        }


        cyclicPhaser.runTask(list, 1);
    }

}
