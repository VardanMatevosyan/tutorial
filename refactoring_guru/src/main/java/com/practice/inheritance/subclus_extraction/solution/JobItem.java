package com.practice.inheritance.subclus_extraction.solution;

/**
 * // todo
 * Solution.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
abstract class JobItem {
    private int quantity;

    protected JobItem(int quantity) {
        this.quantity = quantity;
    }
    public int getTotalPrice() {
        return quantity * getUnitPrice();
    }
    public int getQuantity() {
        return quantity;
    }
    public abstract int getUnitPrice();
}
