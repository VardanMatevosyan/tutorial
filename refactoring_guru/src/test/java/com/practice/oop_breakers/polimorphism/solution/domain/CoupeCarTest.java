package com.practice.oop_breakers.polimorphism.solution.domain;

import org.junit.Assert;
import org.junit.Test;

public class CoupeCarTest {

    @Test
    public void testSedanCarCalculateInsuranceRate() {
        int expectedRate = 200;

        Car car = new CoupeCar();

        Integer actualRate = car.calculateInsuranceRate();

        Assert.assertEquals(expectedRate, actualRate, 0);
    }
}