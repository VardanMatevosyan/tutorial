package com.practice.principle.dependencyInversion.problem.entity;

import org.junit.Test;
import com.practice.principle.dependencyInversion.problem.view.OrderView;

public class DiscountTest {

    @Test
    public void whenDontUserDIP() {
        Discount discount = new Discount();
        Order order = new Order("Simple order", discount);
        OrderView view = new OrderView(order);

        view.printAllProducts();
    }

}
