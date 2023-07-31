package com.practice.methods.fat_method.method_swap.problem;

/**
 * Here we have many fields and few of them even changing own values during calculation,
 * so it is hard to understand what is going on and even make some changes.
 * ---------------------------------------------------------------------------------------------------
 * Solution is to move core functionality that calculates gamma in this case to separate class.
 * make fields as class level fields and extract one method to few more readable and flexible methods.
 * The Code example is from refactoring guru course.
 */
class Account {
    // ...
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        // and so on…
        return importantValue3 - 2 * importantValue1;
    }

    private int delta() {
        return 0;
    }
    // ...
}