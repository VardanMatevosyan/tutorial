package com.practice.methods.fat_method.method_swap.solution;

class Account {
    // ...
    int gamma(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 0;
    }
    // ...
}
