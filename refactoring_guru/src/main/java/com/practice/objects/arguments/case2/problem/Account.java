package com.practice.objects.arguments.case2.problem;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Problem.
 * The method has the same group of arguments and this can lead to code duplication
 * for arguments itself and for frequently operation with these arguments.
 * Example getFlowBetween(Date start, Date end).
 * ------------------------------------------------------------------------------------------
 * Solution.
 * Create a new class which will represent the group of arguments.
 * Make the args to the class make them private and final without setters to avoid
 * someone can change it in the runtime after creation
 * Move all the operation with these args to the methods in the newly created class
 * This solution enhance readability of the classes and methods,
 * instead of having many args with the same interface
 * passing to the method and operations with these args that can be duplicate even in the other classes.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
class Account {
    // ...
    private final Vector<Transaction> transactions = new Vector<>();

    public double getFlowBetween(Date start, Date end) {
        double result = 0;
        Enumeration<Transaction> e = transactions.elements();
        while (e.hasMoreElements()) {
            Transaction each = e.nextElement();
            if (each.getDate().compareTo(start) >= 0 && each.getDate().compareTo(end) <= 0) {
                result += each.getValue();
            }
        }
        return result;
    }
}
