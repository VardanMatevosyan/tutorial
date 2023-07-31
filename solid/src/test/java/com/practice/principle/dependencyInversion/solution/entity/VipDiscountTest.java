package com.practice.principle.dependencyInversion.solution.entity;

import org.junit.Test;
import com.practice.principle.dependencyInversion.solution.view.OrderView;

public class VipDiscountTest {

    @Test
    public void whenUserDIP() {
        IDiscount vipDiscount = new VipDiscount();
        IDiscount simpleDiscount = new Discount();
        Order order = new Order("First VIP order", vipDiscount);
        OrderView view = new OrderView(order);

        view.printAllProducts();

        Order simple = new Order("Second simple order", simpleDiscount);
        OrderView simpleOrderView = new OrderView(simple);
        simpleOrderView.printAllProducts();

    }

}
