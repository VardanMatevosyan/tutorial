package com.practice.principle.openClose.problem.emtity;

import java.util.List;

/**
 * Order class.
 */
public class Order {
    private final List<Product> cart;

    public Order(List<Product> cart, int bonus) {
        this.cart = cart;
    }

    public List<Product> getCart() {
        return cart;
    }

}
