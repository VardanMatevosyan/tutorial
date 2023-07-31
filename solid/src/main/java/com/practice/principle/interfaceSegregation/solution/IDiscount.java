package com.practice.principle.interfaceSegregation.solution;

public interface IDiscount {
    boolean checkPromocode(String promocode);
    int getMaxDiscount();
}
