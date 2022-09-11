package ru.matevosyan.methods.problem;

public class Order {
    private double quantity;
    private double itemPrice;

    public double price() {
        // Price consists of: base price - discount + shipping cost
        return quantity * itemPrice
                - Math.max(0, quantity - 500) * itemPrice * 0.05
                + Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    int discount(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) {
            inputVal -= 2;
        }
        if (quantity > 100) {
            inputVal -= 1;
        }
        if (yearToDate > 10000) {
            inputVal -= 4;
        }
        return inputVal;
    }
}
