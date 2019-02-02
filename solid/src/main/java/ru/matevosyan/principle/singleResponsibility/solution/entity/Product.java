package ru.matevosyan.principle.singleResponsibility.solution.entity;

/**
 * Product entity.
 */
public class Product {
    private String name;
    private double salary;
    private long amount;

    public Product(String name, double salary, long amount) {
        this.name = name;
        this.salary = salary;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, salary: %s, amount: %s ", this.name, this.salary, this.amount);
    }
}
