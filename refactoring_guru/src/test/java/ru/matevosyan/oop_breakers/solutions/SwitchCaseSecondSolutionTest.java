package ru.matevosyan.oop_breakers.solutions;

import org.junit.Assert;
import org.junit.Test;
import ru.matevosyan.oop_breakers.builder.ProductBuilder;
import ru.matevosyan.oop_breakers.builder.UserBuilder;
import ru.matevosyan.oop_breakers.domain.Product;
import ru.matevosyan.oop_breakers.domain.User;

import java.util.Set;

public class SwitchCaseSecondSolutionTest {

    @Test
    public void testCalculateTotal() {
        double expectedTotal = 20;
        SwitchCaseSecondSolution switchCaseSecondSolution = new SwitchCaseSecondSolution();
        Set<Product> products = new ProductBuilder().builder().build();
        User user = new UserBuilder().predefineAll().build();

        double total = switchCaseSecondSolution.calculateTotal(products, user);

        Assert.assertEquals(expectedTotal, total, 0.0);
    }

}