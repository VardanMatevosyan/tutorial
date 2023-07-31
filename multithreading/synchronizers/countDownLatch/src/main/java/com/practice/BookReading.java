package com.practice;

import java.util.concurrent.CountDownLatch;

/**
 * BookReading class for using CountDownLatch synchronize class is wait for reading all chapter.
 * which is number of latch.
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */

public class BookReading extends Thread {
    private final CountDownLatch chapterLatch;
    private final int chapterID;

    public BookReading(CountDownLatch chapterLatch, int chapterID) {
        this.chapterLatch = chapterLatch;
        this.chapterID = chapterID;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting to read chapter # " + this.chapterID);
            Thread.sleep(this.chapterID * 100 + 500);
            System.out.println("Chapter # " + this.chapterID + " is done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.chapterLatch.countDown();
        }

    }
}
