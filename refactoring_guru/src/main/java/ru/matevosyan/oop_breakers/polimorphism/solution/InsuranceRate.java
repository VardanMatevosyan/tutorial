package ru.matevosyan.oop_breakers.polimorphism.solution;

import ru.matevosyan.oop_breakers.polimorphism.solution.domain.Car;

/**
 * Problem.
 * broke SRP and OCP principles
 * ------------------------------------------------------------------------------------------
 * Solution.
 * Using polymorphism.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
public class InsuranceRate {

    public Integer calculate(Car car) {
        return car.calculateInsuranceRate();
    }

}
