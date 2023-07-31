package com.practice;

import org.junit.Test;

/**
 * Testing HotelVisitor class which is use semaphore describing class as {@link HotelBathRoomSemaphoreExample}
 * Created on 12.11.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */
public class HotelVisitorTest {
    private static final int COUNT_OF_BATHROOM = 2;
    private static final int MAX_COUNT_OF_VISITOR = 8;
    private HotelBathRoomSemaphoreExample hotelBathRoom = new HotelBathRoomSemaphoreExample(COUNT_OF_BATHROOM);

    @Test
    public void whenCreateEightVisitorsThanTakeShowerInOneTimeFourTimes() {
        HotelVisitor visitor = null;
        for (int counterForVisitor = 0; counterForVisitor < MAX_COUNT_OF_VISITOR; counterForVisitor++) {
            visitor = new HotelVisitor(hotelBathRoom, counterForVisitor);
            visitor.start();
        }
        for (int counterForVisitor = 0; counterForVisitor < MAX_COUNT_OF_VISITOR; counterForVisitor++) {
            try {
                visitor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}