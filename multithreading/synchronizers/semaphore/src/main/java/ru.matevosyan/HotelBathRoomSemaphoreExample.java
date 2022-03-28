package ru.matevosyan;

import java.util.concurrent.Semaphore;

/**
 * HotelBathRoomSemaphoreExample class for dedicate semaphore behaviour.
 * Created on 12.11.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class HotelBathRoomSemaphoreExample {
    private final Semaphore bathRoom;

    public HotelBathRoomSemaphoreExample(int bathRoomCount) {
        bathRoom = new Semaphore(bathRoomCount);
    }

    public void getKeyAndOpenBathRoomForTackingShowerAndCloseForOthers(int visitorID) {
        try {
            System.out.println("Hello " + visitorID + ". You are trying to get key for bathRoom");
            this.bathRoom.acquire();
            System.out.println("Welcome " + visitorID + ". Have a nice day");
        } catch (InterruptedException ie) {
            System.out.println("First of all, you should get the key!!!");
        }
    }

    public void finishTackingShowerAndReturnTheKey(int visitorID) {
        System.out.println(visitorID + " trying to return the key");
        this.bathRoom.release();
        System.out.println(visitorID + "Return the key.");
    }
}
