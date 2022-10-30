package ru.matevosyan.methods.parametrization.solution;

import ru.matevosyan.methods.parametrization.EmployeeType;

import java.util.Collection;

/**
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
        raise(1.5);
    }

    public void raise(double percent) {
        salary *= (1 + percent);
    }
}

