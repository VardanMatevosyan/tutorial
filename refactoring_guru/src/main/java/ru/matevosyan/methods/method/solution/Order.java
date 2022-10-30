package ru.matevosyan.methods.method.solution;

public class Order {
    private double quantity;
    private double itemPrice;

    /**
     * Warning!!!
     * Sometime temporary variable uses like cache for heavy operation (or some use of recursion).
     * Therefore, before refactoring, you need to check what the method does.
     *
     * @return order price.
     */
    public double price() {
        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }

    /**
     * Use final for method arguments to avoid assigning new values to them.
     * Use new result variable to assign arg value if needed.
     *
     * @param inputVal discount
     * @param quantity discount
     * @param yearToDate discount
     * @return discount
     */
    int discount(final int inputVal, final int quantity, final int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) {
            result -= 2;
        }
        if (quantity > 100) {
            result -= 1;
        }
        if (yearToDate > 10000) {
            result -= 4;
        }
        return result;
    }
}
