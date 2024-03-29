package com.practice.principle.openClose.solution.view;

import com.practice.principle.openClose.problem.emtity.Order;
import com.practice.principle.openClose.problem.emtity.Product;
import com.practice.principle.openClose.solution.repository.OrderRepository;
import com.practice.principle.openClose.problem.storage.Storage;

import java.util.List;

/**
 * ProductView for showing the information.
 */
public class OrderView {
    private OrderRepository<Order> repository = new OrderRepository<>();
    public OrderView() {
    }

    public void showAllProducts() {
        for (Order order : Storage.STORAGE.getStorage()) {
            System.out.println("Order in the browser: ");
            System.out.println("Total price is " + repository.calculateTotalPrice());
            List<Product> cart = order.getCart();
            for (Product product : cart) {
                System.out.println(String.format("Product %s", product.toString()));
            }
        }
    }

    public void printAllProducts() {
        for (Order order : Storage.STORAGE.getStorage()) {
            System.out.println("Order in the console: ");
            System.out.println("Total price is " + repository.calculateTotalPrice());
            List<Product> cart = order.getCart();
            for (Product product : cart) {
                System.out.println(String.format("Product %s", product.toString()));
            }
        }
    }

}
