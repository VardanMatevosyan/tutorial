package com.practice.v1;

/**
 * HotelVisitor class for using SEMAPHORE HotelBathRoomSemaphoreExample for running in multiply threads.
 * HotelVisitor describe visitors behavior.
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */

public class HotelVisitor extends Thread {
    private HotelBathRoomSemaphoreExample hotelsBathRoom;
    private int visitorID;

    public HotelVisitor(HotelBathRoomSemaphoreExample hotelsBathRoom, int visitorID) {
        this.hotelsBathRoom = hotelsBathRoom;
        this.visitorID = visitorID;
    }

    public void run() {
        this.hotelsBathRoom.getKeyAndOpenBathRoomForTackingShowerAndCloseForOthers(this.visitorID);
        try {
            int showeringTime = this.visitorID * 100;
            System.out.println(this.visitorID + " will finished taking shower for " + showeringTime + " seconds");
            Thread.sleep(showeringTime);
            System.out.println(visitorID + "is done");
        } catch (InterruptedException ie) {
            System.out.println("Something goes wrong. Where " + this.visitorID);
        } finally {
            this.hotelsBathRoom.finishTackingShowerAndReturnTheKey(this.visitorID);
        }
    }
}
