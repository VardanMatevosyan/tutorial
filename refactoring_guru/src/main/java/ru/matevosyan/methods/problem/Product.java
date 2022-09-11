package ru.matevosyan.methods.problem;

public class Product {
    private double quantity;
    private double itemPrice;


    /**
     * Be careful! Before refactoring need to check if local variable assign only ones.
     *
     * @return price.
     */
    public double getPrice() {
        double basePrice = quantity * itemPrice;
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        }
        else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }
}