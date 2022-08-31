package ru.matevosyan.oop_breakers.solutions;

import ru.matevosyan.oop_breakers.domain.Product;
import ru.matevosyan.oop_breakers.domain.User;

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
