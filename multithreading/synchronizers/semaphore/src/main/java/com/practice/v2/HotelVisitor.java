package com.practice.v2;

import java.util.Random;


public class HotelVisitor extends Thread {
    private final HotelBathRoomSemaphore hotelBathRoom;
    private final String visitor;

    HotelVisitor(HotelBathRoomSemaphore hotelBathRoom, String visitor) {
        this.hotelBathRoom = hotelBathRoom;
        this.visitor = visitor;
    }

    public void run() {
        hotelBathRoom.startTackingShower(visitor);
        try {
            int showeringTime = new Random().nextInt(5) * 100;
            System.out.println(visitor + " will finished taking shower for " + showeringTime + " seconds");
            Thread.sleep(showeringTime);
            System.out.println(visitor + " is done");
        } catch (InterruptedException e) {
            System.out.println("Something goes wrong. Where " + visitor);
        } finally {
            hotelBathRoom.finishTackingShower(visitor);
        }
    }
}
