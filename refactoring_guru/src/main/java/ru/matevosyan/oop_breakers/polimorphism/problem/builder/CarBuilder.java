package ru.matevosyan.oop_breakers.polimorphism.problem.builder;

import ru.matevosyan.oop_breakers.polimorphism.problem.domain.Car;

public class CarBuilder {
    private final Car car = new Car();

    public CarBuilder type(String type) {
        car.setType(type);
        return this;
    }

    public CarBuilder brand(String brand) {
        car.setBrand(brand);
        return this;
    }

    public Car build() {
        return car;
    }

}
