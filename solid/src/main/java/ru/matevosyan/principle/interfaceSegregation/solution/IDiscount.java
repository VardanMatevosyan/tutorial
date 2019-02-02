package ru.matevosyan.principle.interfaceSegregation.solution;

public interface IDiscount {
    boolean checkPromocode(String promocode);
    int getMaxDiscount();
}
