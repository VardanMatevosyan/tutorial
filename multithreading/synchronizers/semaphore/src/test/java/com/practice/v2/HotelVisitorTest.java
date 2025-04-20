package com.practice.v2;

import org.junit.Test;

public class HotelVisitorTest {

    @Test
    public void testTwoVisitorsTakeShowerAndReturnTheKey() {
        HotelBathRoomSemaphore hotelBathRoom = new HotelBathRoomSemaphore(1);
        HotelVisitor mary = new HotelVisitor(hotelBathRoom, "Elon");
        HotelVisitor elon = new HotelVisitor(hotelBathRoom, "Mary");

        takeShower(mary);
        takeShower(elon);

        waitThreadFinished(mary);
        waitThreadFinished(elon);
    }

    private static void takeShower(HotelVisitor visitor) {
        visitor.start();
    }

    private static void waitThreadFinished(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Magic");
        }
    }
}