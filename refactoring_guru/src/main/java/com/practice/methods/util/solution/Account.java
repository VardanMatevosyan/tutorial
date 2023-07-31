package com.practice.methods.util.solution;

import java.util.Date;
import java.util.Random;

/**
 * Solution is to create Util class service and move the common methods to related external class.
 * Then you could use it from any place in your project and the logic would not change by mistake
 * and the risk is low, and also you can avoid duplicate the code and avoid the chance to make a mistake
 * because you should change many places where these methods need these changes.
 * In our case we have Account class and we use separate class DateUtils where we have our methods to use here.
 * ----------------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Account {
    // ...
    double schedulePayment() {
        Date paymentDate = new DateUtils(new Date()).nextWeek();

        // Issue a payment using paymentDate.
        // ...
        // lets return any double just for example
        return new Random().nextDouble();
    }
}
