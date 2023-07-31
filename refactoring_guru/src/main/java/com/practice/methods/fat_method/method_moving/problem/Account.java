package com.practice.methods.fat_method.method_moving.problem;

/**
 * Here the see that the problem could be if the AccountType will have more then one type
 * and if for each account type we would need to calculate overdraft charge differently.
 * ---------------------------------------------------------------------------------------
 * One of the solutions can be to move the method to AccountType class.
 * Or another solution that was no represent in the course is to use strategy pattern. So each type will have
 * own service with own logic to calculate the overdraft charge.
 * Or to use enum to map type to Function this can be used in AccountType class.
 * ----------------------------------------------------------------------------------------
 * Note: we don't need to move daysOverdrawn to AccountType class because this field value depends on Account.
 * It could different value for different accounts.
 * ----------------------------------------------------------------------------------------
 * The Code example is from refactoring guru course.
 */
class Account {
    // ...
    private AccountType type;
    private int daysOverdrawn;

    public double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        } else {
            return daysOverdrawn * 1.75;
        }
    }

    public double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += overdraftCharge();
        }
        return result;
    }
}
