package ru.matevosyan.principle.openClose.solution.repository;

import ru.matevosyan.principle.openClose.problem.emtity.Order;
import ru.matevosyan.principle.openClose.problem.emtity.Product;
import ru.matevosyan.principle.openClose.problem.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository<T extends Order> extends BaseRepository {

    public OrderRepository() {}

    @Override
    public void save(Order order) {
        Storage.STORAGE.getStorage().add(order);
    }

    @Override
    public void delete(Order order) {
         Storage.STORAGE.getStorage().remove(order);
    }

    @Override
    double getDiscount() {
        return 20;
    }

    @Override
    List<Product> getProducts() {
        List<Product> totalListOfProducts = new ArrayList<>();
        List<Order> storage = Storage.STORAGE.getStorage();
        for (Order order : storage) {
            List<Product> cart = order.getCart();
            totalListOfProducts.addAll(cart);
        }
        return totalListOfProducts;
    }
}
