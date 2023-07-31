package com.practice.principle.dependencyInversion.problem.entity;

/**
 * Order class.
 */
public class Order {
    private String name;
    private final Discount discount;

    public Order(String name, Discount discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getTotalDiscount() {
        return this.discount.calculate();
    }
}
