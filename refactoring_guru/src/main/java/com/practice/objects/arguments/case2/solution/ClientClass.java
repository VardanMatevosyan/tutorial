package com.practice.objects.arguments.case2.solution;

import java.util.Date;

public class ClientClass {
    void someMethod(Account account) {
        // Somewhere in client code…
        double flow = account.getFlowBetween(new DateRange(new Date(), new Date()));
    }
}
