package ru.matevosyan.oop_breakers.polimorphism.solution.domain;

public abstract class Car {
    private String brand;
    private String type;

     public abstract Integer calculateInsuranceRate();

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
