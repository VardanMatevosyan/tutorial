package ru.matevosyan.oop_breakers.polimorphism.solution.domain;

public class CoupeCar extends Car {
    @Override
    public Integer calculateInsuranceRate() {
        return 200;
    }
}
