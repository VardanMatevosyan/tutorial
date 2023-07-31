package com.practice.methods.fat_method.method_moving.solution;

class Account {
    // ...
    private AccountType type;
    private int daysOverdrawn;

    public double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += type.overdraftCharge(this);
        }
        return result;
    }

    public int getDaysOverdrawn() {
        return 9;
    }
}
