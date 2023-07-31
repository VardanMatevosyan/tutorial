package com.practice.fields.moving.problem;

/**
 * Problem occurs when we have field that doesn't belong to the class where the is created.
 * or when hard to determine in which class the filed should be.
 * ----------------------------------------------------------------------------------------------
 * Solution: need to follow the rules:
 * firstly need to follow the SRP principle, then we should not have a problem
 * or secondly need to determine in which class we have more methods that uses this field.
 * ----------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Account {
    // ...
    private AccountType type;
    private double interestRate;

    public double interestForAmount_days(double amount, int days) {
        return interestRate * amount * days / 365.0;
    }
}

class AccountType {
    // ...
}
