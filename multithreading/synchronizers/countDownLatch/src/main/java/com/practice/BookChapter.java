package com.practice;

import java.util.concurrent.CountDownLatch;

/**
 * BookChapter class for using CountDownLatch synchronize class.
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */

public class BookChapter extends Thread {
    private final CountDownLatch chapterLatch;

    public BookChapter(CountDownLatch chapterLatch) {
        this.chapterLatch = chapterLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Wait for all chapters.");
            this.chapterLatch.await();
            System.out.println("All chapters is passed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
