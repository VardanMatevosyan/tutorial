package com.practice.principle.openClose.solution.repository;
import com.practice.principle.openClose.problem.emtity.Order;
import com.practice.principle.openClose.problem.emtity.Product;
import java.util.List;

abstract class BaseRepository {
    abstract double getDiscount();
    abstract List<Product> getProducts();
    abstract void save(Order order);
    abstract void delete(Order order);

    public double calculateTotalPrice() {
        double discount = this.getDiscount();
        List<Product> products = this.getProducts();
        return calculate(discount, products);
    }

    public double calculate(double discount, List<Product> list) {
        double totalPrice = 0;
        int percent = 100;
        for (Product product : list) {
            double productPrice = product.getAmount() * product.getSalary();
            totalPrice += productPrice - (productPrice * discount / percent);
        }
        return  totalPrice;
    }
}
