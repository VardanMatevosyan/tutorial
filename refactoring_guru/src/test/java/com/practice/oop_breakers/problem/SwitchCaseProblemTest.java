package com.practice.oop_breakers.problem;

import org.junit.Assert;
import org.junit.Test;
import com.practice.oop_breakers.method_extraction.builder.ProductBuilder;
import com.practice.oop_breakers.method_extraction.builder.UserBuilder;
import com.practice.oop_breakers.method_extraction.domain.Product;
import com.practice.oop_breakers.method_extraction.domain.User;
import com.practice.oop_breakers.method_extraction.problem.SwitchCaseProblem;

import java.util.Set;

public class SwitchCaseProblemTest {

    @Test
    public void testCalculateTotal() {
        double expectedTotal = 40;
        SwitchCaseProblem switchCaseProblem = new SwitchCaseProblem();
        Set<Product> products = new ProductBuilder().builder().build();
        User user = new UserBuilder().predefineAll().build();

        double total = switchCaseProblem.calculateTotal(products, user);

        Assert.assertEquals(expectedTotal, total, 0.0);
    }

}