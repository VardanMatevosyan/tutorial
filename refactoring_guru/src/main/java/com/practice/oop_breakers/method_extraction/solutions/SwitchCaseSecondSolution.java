package com.practice.oop_breakers.method_extraction.solutions;

import com.practice.oop_breakers.method_extraction.domain.Product;
import com.practice.oop_breakers.method_extraction.domain.User;

import java.util.Set;

public class SwitchCaseSecondSolution {

    public double calculateTotal(Set<Product> products, User user) {
        double total = 0;
        for (Product product : products) {
            total += product.getQuantity() * product.getPrice();
        }
        total = Discount.applyRegionalDiscounts(total, user.getCountry());
        total = Discount.applyCoupons(total);
        return total;
    }
}
