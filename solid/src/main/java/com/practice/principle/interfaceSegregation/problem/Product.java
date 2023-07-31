package com.practice.principle.interfaceSegregation.problem;

import java.util.Date;

public interface Product {
    String getName();
    String getDepartment();
    double getPrice();
    String getColor();
    String getModel();
    Date publishYear();
    boolean checkPromocode(String promocode);
    int getMaxDiscount();
}
