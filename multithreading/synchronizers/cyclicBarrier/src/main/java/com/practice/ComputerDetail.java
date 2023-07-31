package com.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ComputerDetail class for using CyclicBarrier for synchronized.
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */

public class ComputerDetail extends Thread {
    private final CyclicBarrier barrier;
    private final int detailId;

    public ComputerDetail(CyclicBarrier barrier, int detailId) {
        this.barrier = barrier;
        this.detailId = detailId;
    }

    @Override
    public void run() {
        int timeToInstallDetail = this.detailId * 100 + 100;
        try {
            System.out.println("Detail will be installed in " + this.detailId + " seconds");
            Thread.sleep(timeToInstallDetail);
            System.out.println("Detail " + this.detailId + " is installed and waiting for other detail to install too ");
            this.barrier.await();
            System.out.println("\n Testing...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
        e.printStackTrace();
        }
    }
}
