package com.practice.principle.dependencyInversion.solution.entity;

public class VipDiscount implements IDiscount {
    @Override
    public int calculate() {
        return 45;
    }
}
