package com.practice.oop_breakers.solutions;

import org.junit.Assert;
import org.junit.Test;
import com.practice.oop_breakers.method_extraction.builder.ProductBuilder;
import com.practice.oop_breakers.method_extraction.builder.UserBuilder;
import com.practice.oop_breakers.method_extraction.domain.Product;
import com.practice.oop_breakers.method_extraction.domain.User;
import com.practice.oop_breakers.method_extraction.solutions.SwitchCaseSecondSolution;

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