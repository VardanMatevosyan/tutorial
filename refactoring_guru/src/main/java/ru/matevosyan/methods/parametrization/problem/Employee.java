package ru.matevosyan.methods.parametrization.problem;

import ru.matevosyan.methods.parametrization.EmployeeType;

import java.util.Collection;

/**
 * Problem.
 * We have different methods that doing same thing, and the result depends on specific changeable parameter.
 * ------------------------------------------------------------------------------------------
 * Solution.
 * Create new method with changeable parameter and move duplicate code to that method
 * Change all old method invocation to the new one and pass the changeable parameter.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
class Employee {
    Integer yearsOfExperience;
    Collection<String> clients;
    double salary;
    EmployeeType type;

    // ... other fields

    public void promoteToManager() {
        type = EmployeeType.MANAGER;
        salary *= 1.5;
    }
    public void tenPercentRaise() {
        salary *= 1.1;
    }
    public void fivePercentRaise() {
        salary *= 0.05;
    }
}

