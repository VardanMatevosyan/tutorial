package ru.matevosyan.principle.dependencyInversion.problem.entity;

import java.util.List;

/**
 * Order class.
 */
public class Order {
    private String name;
    private Discount discount;

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
