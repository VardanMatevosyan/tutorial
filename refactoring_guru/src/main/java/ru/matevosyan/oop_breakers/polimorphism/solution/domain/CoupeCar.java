package ru.matevosyan.oop_breakers.polimorphism.solution.domain;

public class CoupeCar extends Car {
    @Override
    Integer calculateInsuranceRate() {
        return 200;
    }
}
