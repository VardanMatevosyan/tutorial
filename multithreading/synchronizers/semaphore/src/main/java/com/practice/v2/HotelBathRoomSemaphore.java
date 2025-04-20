package com.practice.v2;

import java.util.concurrent.Semaphore;

public class HotelBathRoomSemaphore {
    private final Semaphore bathRoom;

    HotelBathRoomSemaphore(int bathRoomSize) {
        this.bathRoom = new Semaphore(bathRoomSize);
    }

    public void startTackingShower(String visitor) {
        try {
            System.out.println("Hello " + visitor + ". You are trying to get key for bathRoom");
            this.bathRoom.acquire();
            System.out.println("Welcome " + visitor + ". Have a nice day");
        } catch (InterruptedException ie) {
            System.out.println("First of all, you should get the key!!!");
        }
    }

    public void finishTackingShower(String visitor) {
        System.out.println(visitor + " trying to return the key");
        this.bathRoom.release();
        System.out.println(visitor + " returned the key.");
    }
}
