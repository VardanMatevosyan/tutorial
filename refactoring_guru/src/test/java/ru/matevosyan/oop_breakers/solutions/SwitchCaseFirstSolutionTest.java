package ru.matevosyan.oop_breakers.solutions;

import org.junit.Assert;
import org.junit.Test;
import ru.matevosyan.oop_breakers.method_extraction.builder.ProductBuilder;
import ru.matevosyan.oop_breakers.method_extraction.builder.UserBuilder;
import ru.matevosyan.oop_breakers.method_extraction.domain.Product;
import ru.matevosyan.oop_breakers.method_extraction.domain.User;
import ru.matevosyan.oop_breakers.method_extraction.solutions.SwitchCaseFirstSolution;

import java.util.Set;

public class SwitchCaseFirstSolutionTest {

    @Test
    public void testCalculateTotal() {
        double expectedTotal = 40;
        SwitchCaseFirstSolution switchCaseFirstSolution = new SwitchCaseFirstSolution();
        Set<Product> products = new ProductBuilder().builder().build();
        User user = new UserBuilder().predefineAll().build();

        double total = switchCaseFirstSolution.calculateTotal(products, user);

        Assert.assertEquals(expectedTotal, total, 0.0);
    }
}