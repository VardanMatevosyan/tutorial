package ru.matevosyan.methods.problem;

import org.junit.Assert;
import org.junit.Test;
import ru.matevosyan.methods.method.problem.Salary;

public class SalaryTest {

    @Test
    public void testTwoPercentRaise() {
        double expected = 2040.0;

        Salary salary = new Salary();

        double raisedSalary = salary.twoPercentRaise(2000);

        Assert.assertEquals(expected, raisedSalary, 0.0);
    }

}