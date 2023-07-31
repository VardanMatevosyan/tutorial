package com.practice.methods.fat_method.method_moving.solution;

class AccountType {
    // ...
    // ...
    public double overdraftCharge(Account account) {
        if (isPremium()) {
            double result = 10;
            if (account.getDaysOverdrawn() > 7) {
                result += (account.getDaysOverdrawn() - 7) * 0.85;
            }
            return result;
        } else {
            return account.getDaysOverdrawn() * 1.75;
        }
    }
    // ...
    private boolean isPremium() {
        return false;
    }
}
