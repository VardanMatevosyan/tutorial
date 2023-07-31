package com.practice.principle.openClose.problem.storage;

import com.practice.principle.openClose.problem.emtity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductRepository is repository for Product.
 */
public enum Storage {
    STORAGE;
    private final List<Order> storage = new ArrayList<>();

    Storage() {
    }

    public List<Order>  getStorage() {
        return this.storage;
    }
}
