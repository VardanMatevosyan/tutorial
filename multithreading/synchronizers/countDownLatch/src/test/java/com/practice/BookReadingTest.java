package com.practice;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * BookReadingTest class for testing using BookReading class and BookChapter class.
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */

public class BookReadingTest {
    private static final int COUNT_LATCH = 5;
    private CountDownLatch countDownLatch = new CountDownLatch(COUNT_LATCH);
    private BookReading bookReading;
    private BookChapter bookChapter;
    @Test
    public void whenThan() {
        for (int chapterID = 0; chapterID < COUNT_LATCH; chapterID++) {
            this.bookReading = new BookReading(this.countDownLatch, chapterID);
            this.bookChapter = new BookChapter(this.countDownLatch);
            this.bookChapter.start();
            this.bookReading.start();
        }

        for (int chapterID = 0; chapterID < COUNT_LATCH; chapterID++) {
            try {
                this.bookChapter.join();
                this.bookReading.join();
            } catch (InterruptedException ie) {
                System.out.println("Something goes wrong");
            }
        }


    }

}