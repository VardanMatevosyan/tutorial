package ru.matevosyan.principle.singleResponsibility.solution.storage;

import ru.matevosyan.principle.singleResponsibility.solution.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductRepository is repository for Product.
 */
public enum Storage {
    STORAGE;
    private final List<Product> storage = new ArrayList<>();

    Storage() {
    }

    public List<Product>  getStorage() {
        return this.storage;
    }
}
