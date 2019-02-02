package ru.matevosyan.principle.dependencyInversion.solution.entity;

public class VipDiscount implements IDiscount {
    @Override
    public int calculate() {
        return 45;
    }
}
