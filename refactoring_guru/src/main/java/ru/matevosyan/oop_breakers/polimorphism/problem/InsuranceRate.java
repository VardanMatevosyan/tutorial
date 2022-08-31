package ru.matevosyan.oop_breakers.polimorphism.problem;

import ru.matevosyan.oop_breakers.polimorphism.problem.domain.Car;

public class InsuranceRate {

    public Integer calculate(Car car) {
        switch (car.getType()) {
            case "Sedan":
                return getBaseInsuranceRate();
            case "Coupe":
                return getHighInsuranceRate();
            default:
                throw new RuntimeException("Can't determine car type");
        }
    }

    private Integer getHighInsuranceRate() {
        return 200;
    }

    private Integer getBaseInsuranceRate() {
        return 100;
    }
}
