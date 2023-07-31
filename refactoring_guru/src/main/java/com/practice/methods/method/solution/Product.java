package com.practice.methods.method.solution;

public class Product {
    private double quantity;
    private double itemPrice;


    public double getPrice() {
        return basePrice() * discountFactor();
    }

    private double basePrice() {
        return quantity * itemPrice;
    }

    private double discountFactor() {
        if (basePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }
}