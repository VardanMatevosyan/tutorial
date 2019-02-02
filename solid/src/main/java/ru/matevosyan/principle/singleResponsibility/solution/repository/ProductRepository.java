package ru.matevosyan.principle.singleResponsibility.solution.repository;

import ru.matevosyan.principle.singleResponsibility.solution.entity.Product;
import ru.matevosyan.principle.singleResponsibility.solution.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductRepository is repository for Product.
 */
public class ProductRepository<T extends Product> {
    public ProductRepository() { }

    public void save(Product product) {
        Storage.STORAGE.getStorage().add(product);
    }
    public boolean delete(Product product) {
        return Storage.STORAGE.getStorage().remove(product);
    }

}
