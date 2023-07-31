package com.practice.methods.fat_method.method_swap.solution;

class Gamma {
    private final Account account;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;
    private int inputVal;
    private int quantity;
    private int yearToDate;

    Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
        this.account = source;
        inputVal = inputValArg;
        quantity = quantityArg;
        yearToDate = yearToDateArg;
    }
    public int compute() {
        importantValue1 = (inputVal * quantity) + account.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        importantThing();
        importantValue3 = importantValue2 * 7;
        // and so on…
        return importantValue3 - 2 * importantValue1;
    }
    void importantThing() {
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
    }
}
