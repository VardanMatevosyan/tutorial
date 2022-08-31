package ru.matevosyan.oop_breakers.solutions;

public final class Discount {

    private Discount() {}

    public static double applyRegionalDiscounts(double total, String country) {
        double result = total;
        switch (country) {
            case "US": result *= 1; break;
            case "UA": result *= 2; break;
            case "CN": result *= 3; break;
            // ...
        }
        return result;
    }


    // for example can be many common methods for the discount
    public static double applyCoupons(double total) {
        // ...
        return total * 0.5;
    }
}
