package com.practice.principle.singleResponsibility.problem;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double salary;
    private long amount;
    private List<Product> storage = new ArrayList<>();

    Product(String name, double salary, long amount) {
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

    public void save(Product product) {
        storage.add(product);
    }

    public boolean delete(Product product) {
        return this.storage.remove(product);
    }

    public void showAllProducts() {
        for (Product product : this.storage) {
            System.out.println(String.format("show %s in the browser", product.toString()));
        }
    }

    public void printAllProducts() {
        for (Product product : this.storage) {
            System.out.println(String.format("print %s in the console", product.toString()));
        }
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, salary: %s, amount: %s ", this.name, this.salary, this.amount);
    }
}
