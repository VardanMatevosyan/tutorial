package ru.matevosyan.principle.openClose.problem.repository;

import ru.matevosyan.principle.openClose.problem.emtity.Order;
import ru.matevosyan.principle.openClose.problem.emtity.Product;
import ru.matevosyan.principle.openClose.problem.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository<T extends Order> {

    public OrderRepository() {
    }

    public void save(Order order) {
        Storage.STORAGE.getStorage().add(order);
    }
    public void delete(Order order) {
         Storage.STORAGE.getStorage().remove(order);
    }

    private double getDiscount() {
        return 20;
    }

    private List<Product> getProducts() {
        List<Product> totalListOfProducts = new ArrayList<>();
        List<Order> storage = Storage.STORAGE.getStorage();
        for (Order order : storage) {
            List<Product> cart = order.getCart();
            totalListOfProducts.addAll(cart);
        }
        return totalListOfProducts;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        int percent = 100;
        for (Product product : this.getProducts()) {
            double productPrice = product.getAmount() * product.getSalary();
            totalPrice += productPrice - (productPrice * this.getDiscount() / percent);
        }
        return  totalPrice;
    }


}
