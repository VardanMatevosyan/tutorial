package com.practice.principle.openClose.solution.repository;

import org.junit.Test;
import com.practice.principle.openClose.problem.emtity.Order;
import com.practice.principle.openClose.problem.emtity.Product;
import com.practice.principle.openClose.problem.view.OrderView;

import java.util.Arrays;
import java.util.List;

/**
 * OrderRepositoryTest class.
 */
public class OrderRepositoryTest {

    @Test
    public void when() {
        List<Product> products = Arrays.asList(
                new Product("coffee", 250, 1),
                new Product("milk", 150, 2));

        Order order = new Order(products, 20);

        BaseRepository repository = new OrderRepository<Order>();
        OrderView productView = new OrderView();

        repository.save(order);
        productView.printAllProducts();
        productView.showAllProducts();
        repository.delete(order);
        productView.printAllProducts();
        productView.showAllProducts();
    }

}
