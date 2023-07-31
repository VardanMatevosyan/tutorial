package com.practice.principle.dependencyInversion.problem.view;

import com.practice.principle.dependencyInversion.problem.entity.Order;

/**
 * ProductView for showing the information.
 */
public class OrderView {
    private Order order;

    public OrderView(Order order) {
        this.order = order;
    }

    public void printAllProducts() {
        System.out.println("Name is " + this.order.getName());
        System.out.println("Discount is " + this.order.getTotalDiscount());
    }

}
