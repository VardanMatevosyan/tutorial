package ru.matevosyan.oop_breakers.polimorphism.problem.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Car {
    private String brand;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
