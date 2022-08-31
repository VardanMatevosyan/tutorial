package ru.matevosyan.oop_breakers.method_extraction.solutions;

import ru.matevosyan.oop_breakers.method_extraction.domain.Product;
import ru.matevosyan.oop_breakers.method_extraction.domain.User;

import java.util.Set;

public class SwitchCaseFirstSolution {

    public double calculateTotal(Set<Product> products, User user) {
        double total = 0;
        for (Product product : products) {
            total += product.getQuantity() * product.getPrice();
        }
        return applyRegionalDiscounts(user, total);
    }

    private static double applyRegionalDiscounts(User user, double total) {
        switch (user.getCountry()) {
            case "US": total *= 1; break;
            case "UA": total *= 2; break;
            case "CN": total *= 3; break;
        }
        return total;
    }
}
