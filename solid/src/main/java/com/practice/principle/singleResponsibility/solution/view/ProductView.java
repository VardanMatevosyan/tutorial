package com.practice.principle.singleResponsibility.solution.view;

import com.practice.principle.singleResponsibility.solution.entity.Product;
import com.practice.principle.singleResponsibility.solution.storage.Storage;

/**
 * ProductView for showing the information.
 */
public class ProductView {

    public ProductView() {
    }

    public void showAllProducts() {
        for (Product product : Storage.STORAGE.getStorage()) {
            System.out.println(String.format("show %s in the browser", product.toString()));
        }
    }

    public void printAllProducts() {
        for (Product product : Storage.STORAGE.getStorage()) {
            System.out.println(String.format("print %s in the console", product.toString()));
        }
    }

}
