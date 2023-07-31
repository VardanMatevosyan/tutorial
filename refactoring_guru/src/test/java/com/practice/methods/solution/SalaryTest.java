package com.practice.methods.solution;

import org.junit.Assert;
import org.junit.Test;
import com.practice.methods.method.solution.Salary;

public class SalaryTest {

    @Test
    public void testTwoPercentRaise() {
        double expected = 2040.0;

        Salary salary = new Salary();

        double raisedSalary = salary.raise(2000, 2);

        Assert.assertEquals(expected, raisedSalary, 0.0);
    }

    @Test
    public void testFivePercentRaise() {
        double expected = 3150.0;

        Salary salary = new Salary();

        double raisedSalary = salary.raise(3000, 5);

        Assert.assertEquals(expected, raisedSalary, 0.0);
    }

}