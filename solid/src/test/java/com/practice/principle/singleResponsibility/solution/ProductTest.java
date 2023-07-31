package com.practice.principle.singleResponsibility.solution;

import org.junit.Test;
import com.practice.principle.singleResponsibility.solution.entity.Product;
import com.practice.principle.singleResponsibility.solution.repository.ProductRepository;
import com.practice.principle.singleResponsibility.solution.view.ProductView;

public class ProductTest {

    @Test
    public void whenSolutionWasFinedInTheCodeThenShowItToBeAbleToUnderstand() {
        Product product = new Product("coffee", 250, 1);
        ProductRepository<Product> repository = new ProductRepository<>();
        ProductView view = new ProductView();
        repository.save(product);
        view.printAllProducts();
        view.showAllProducts();
        repository.delete(product);
        view.printAllProducts();
        view.showAllProducts();
    }
}
