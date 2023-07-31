package com.practice.principle.singleResponsibility.solution.repository;

import com.practice.principle.singleResponsibility.solution.entity.Product;
import com.practice.principle.singleResponsibility.solution.storage.Storage;

/**
 * ProductRepository is repository for Product.
 * @param <T> Product.
 */
public class ProductRepository<T extends Product> {

    public ProductRepository() {

    }

    public void save(Product product) {
        Storage.STORAGE.getStorage().add(product);
    }
    public boolean delete(Product product) {
        return Storage.STORAGE.getStorage().remove(product);
    }

}
