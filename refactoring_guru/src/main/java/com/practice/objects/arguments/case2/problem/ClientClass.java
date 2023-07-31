package com.practice.objects.arguments.case2.problem;

import java.util.Date;

public class ClientClass {
    void someMethod(Account account) {
        // Somewhere in client code…
        double flow = account.getFlowBetween(new Date(), new Date());
    }
}
