package ru.matevosyan.oop_breakers.polimorphism.solution.domain;

import org.junit.Assert;
import org.junit.Test;

public class SedanCarTest {

    @Test
    public void testSedanCarCalculateInsuranceRate() {
        int expectedRate = 100;

        Car car = new SedanCar();

        Integer actualRate = car.calculateInsuranceRate();

        Assert.assertEquals(expectedRate, actualRate, 0);
    }
}