package ru.matevosyan.principle.openClose.problem.emtity;

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

    public double getSalary() {
        return salary;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, salary: %s, amount: %s ", this.name, this.salary, this.amount);
    }
}
