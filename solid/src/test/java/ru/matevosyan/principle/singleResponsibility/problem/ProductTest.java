package ru.matevosyan.principle.singleResponsibility.problem;

import org.junit.Test;

public class ProductTest {

    @Test
    public void whenProblemIsPresentInTheCodeThenShowItToBeAbleToUnderstand() {
        Product product = new Product("coffee", 250, 1);
        product.save(product);
        String name = product.getName();
        System.out.println("product name is " + name);
        product.printAllProducts();
        product.showAllProducts();
        product.delete(product);
        product.showAllProducts();
    }

}
