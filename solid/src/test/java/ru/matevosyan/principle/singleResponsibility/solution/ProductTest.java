package ru.matevosyan.principle.singleResponsibility.solution;

import org.junit.Test;
import ru.matevosyan.principle.singleResponsibility.solution.entity.Product;
import ru.matevosyan.principle.singleResponsibility.solution.repository.ProductRepository;
import ru.matevosyan.principle.singleResponsibility.solution.view.ProductView;

import static org.junit.Assert.*;

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