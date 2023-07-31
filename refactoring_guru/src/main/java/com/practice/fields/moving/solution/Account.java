package com.practice.fields.moving.solution;

/**
 * Solution: need to follow the rules:
 * firstly need to follow the SRP principle, then we should not have a problem
 * or secondly need to determine in which class we have more methods that uses this field.
 * In out case we moved the interestRate field to the AccountType class
 * and created getters and setters.
 * and in the Account class self encapsulated this field from the AccountType class.
 * Like type.getInterestRate();
 * ----------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Account {
    // ...
    private AccountType type;

    public double interestForAmount_days(double amount, int days) {
        return getInterestRate() * amount * days / 365.0;
    }
    public double interestForBigFamily(double familySize) {
        return getInterestRate() / familySize;
    }

    // other 10 methods, which use getInterestRate()

    private double getInterestRate() {
        return type.getInterestRate();
    }
    private void setInterestRate(double arg) {
        type.setInterestRate(arg);
    }
}
