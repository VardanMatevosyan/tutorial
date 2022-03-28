package ru.matevosyan.principle.openClose.problem.emtity;

import org.junit.Test;
import ru.matevosyan.principle.openClose.problem.repository.OrderRepository;
import ru.matevosyan.principle.openClose.problem.view.OrderView;

import java.util.Arrays;
import java.util.List;

public class OrderTest {
    @Test
    public void whenProblemIsInTheArchitecture() {
        List<Product> products = Arrays.asList(
                new Product("coffee", 250, 1),
                new Product("milk", 150, 2));

        Order order = new Order(products, 20);

        OrderRepository<Order> repository = new OrderRepository<>();
        OrderView productView = new OrderView();

        repository.save(order);
        productView.printAllProducts();
        productView.showAllProducts();
        repository.delete(order);
        productView.printAllProducts();
        productView.showAllProducts();
    }
}
