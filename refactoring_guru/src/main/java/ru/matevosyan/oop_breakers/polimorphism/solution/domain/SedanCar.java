package ru.matevosyan.oop_breakers.polimorphism.solution.domain;

public class SedanCar extends Car {
    @Override
    Integer calculateInsuranceRate() {
        return 100;
    }
}
