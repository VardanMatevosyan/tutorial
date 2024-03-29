package com.practice.oop_breakers.method_extraction.builder;

import com.practice.oop_breakers.method_extraction.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductBuilder {
    private final Set<Product> products = new HashSet<>();

    public ProductBuilder builder() {
        Product firstProduct = new Product();
        firstProduct.setPrice(2);
        firstProduct.setQuantity(2);

        Product secondProduct = new Product();
        secondProduct.setQuantity(4);
        secondProduct.setPrice(4);

        products.add(firstProduct);
        products.add(secondProduct);
        return this;
    }

    public Set<Product> build() {
        return products;
    }

}
