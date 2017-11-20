package ru.matevosyan;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * Testing CyclicBarrier class capabilities using ComputerDetail thread-class.
 * Created on 12.11.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class ComputerDetailTest {
    private final Runnable barrierAction = () -> System.out.println("Computer is installed and ready to work!!!");
    private static final int PARTIES = 4;
    private final CyclicBarrier barrier = new CyclicBarrier(PARTIES, this.barrierAction);

    @Test
    public void whenInstalledAllDetailThanGetReadyComputer() {
        ComputerDetail computerDetail = null;

        for (int detailId = 0; detailId < PARTIES; detailId++) {
            computerDetail = new ComputerDetail(this.barrier, detailId);
            computerDetail.start();
        }

        for (int detailId = 0; detailId < PARTIES; detailId++) {
            try {
                computerDetail.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}