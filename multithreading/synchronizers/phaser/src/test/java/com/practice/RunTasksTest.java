package com.practice;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Admin on 18.11.2017.
 */
public class RunTasksTest {
    private final RunTasks runTasks = new RunTasks();
    @Test
    public void whenThan() {
        CopyOnWriteArrayList<Runnable> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            int k = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("runnable task" + k);
                }
            };

            list.add(runnable);
        }


        runTasks.runTask(list);
    }

}
