package com.practice.methods.util.problem;

import java.util.Date;
import java.util.Random;

/**
 * The problem. If user are using external library and this library doesn't have the methods we need.
 * or you need common method with specific logic you for your project.
 * ----------------------------------------------------------------------------------------------------------
 * Solution is to create Util class service and move the common methods to related external class.
 * Then you could use it from any place in your project and the logic would not change by mistake
 * and the risk is low, and also you can avoid duplicate the code and avoid the chance to make a mistake
 * because you should change many places where these methods need these changes.
 * ----------------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Account {
    // ...
    double schedulePayment() {
        Date paymentDate = nextWeek(new Date());

        // Issue a payment using paymentDate.
        // ...
        // lets return any double just for example
        return new Random().nextDouble();
    }

    /**
     * Foreign method. Should be on Date class.
     * @param arg date
     * @return date
     */
    private static Date nextWeek(Date arg) {
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 7);
    }
}