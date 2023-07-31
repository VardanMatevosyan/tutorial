package com.practice.principle.dependencyInversion.solution.entity;

/**
 * Discount class.
 */
public class Discount implements IDiscount {
    @Override
    public int calculate() {
        return 10;
    }
}
