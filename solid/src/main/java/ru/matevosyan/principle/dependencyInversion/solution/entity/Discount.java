package ru.matevosyan.principle.dependencyInversion.solution.entity;

/**
 * Discount class.
 */
public class Discount implements IDiscount {
    @Override
    public int calculate() {
        return 10;
    }
}
