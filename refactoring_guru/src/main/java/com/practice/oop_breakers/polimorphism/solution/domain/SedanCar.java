package com.practice.oop_breakers.polimorphism.solution.domain;

public class SedanCar extends Car {
    @Override
    public Integer calculateInsuranceRate() {
        return 100;
    }
}
