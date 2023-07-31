package com.practice.oop_breakers.polimorphism.problem;

import org.junit.Assert;
import org.junit.Test;
import com.practice.oop_breakers.polimorphism.problem.builder.CarBuilder;
import com.practice.oop_breakers.polimorphism.problem.domain.Car;

public class InsuranceRateTest {

    @Test
    public void testCarInsuranceRate() {
        int expectedRate = 100;

        InsuranceRate insurance = new InsuranceRate();

        Integer actualRate = insurance.calculate(getCar());

        Assert.assertEquals(expectedRate, actualRate, 0);
    }

    private static Car getCar() {
        return new CarBuilder().brand("Mercedes").type("Sedan").build();
    }
}