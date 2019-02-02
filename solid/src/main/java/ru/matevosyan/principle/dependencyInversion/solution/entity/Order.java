package ru.matevosyan.principle.dependencyInversion.solution.entity;

/**
 * Order class.
 */
public class Order {
    private String name;
    private IDiscount discount;

    public Order(String name, IDiscount discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalDiscount() {
        return this.discount.calculate();
    }
}
