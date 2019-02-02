package ru.matevosyan.principle.dependencyInversion.solution.view;

import ru.matevosyan.principle.dependencyInversion.solution.entity.Order;

/**
 * ProductView for showing the information.
 */
public class OrderView {
    private Order order;

    public OrderView(Order order) {
        this.order = order;
    }

    public void printAllProducts() {
        System.out.println("Order name is " + this.order.getName());
        System.out.println("Discount is " + this.order.getTotalDiscount());
    }

}
