package ru.matevosyan.oop_breakers.domain;

import java.math.BigInteger;

public class Product {
    private Integer quantity;
    private Integer price;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
