package com.practice;

import org.junit.Test;

/**
 * Created by Admin on 05.11.2017.
 */
public class ExecutorExampleTest {

    @Test
    public void whenCreateTenFutureTaskThanGetTenOutput() {
        ExecutorExample<String> executorExample = new ExecutorExample<>(3);

        for (int i = 0; i < 100; i++) {
            executorExample.executeTaskAndFillListOfFuture(executorExample);
        }

        executorExample.outPutAllTaskName();
        executorExample.shutDownExecution();
    }

}