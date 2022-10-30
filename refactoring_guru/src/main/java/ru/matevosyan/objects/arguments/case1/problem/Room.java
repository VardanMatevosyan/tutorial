package ru.matevosyan.objects.arguments.case1.problem;

/**
 * Problem.
 * In this example we're passing two arguments to the plan.withinRange method.
 * ------------------------------------------------------------------------------------------
 * Solution.
 * We can pass the objects itself, so in the future we would have
 * flexibility to use any field values from the object if the business logic will change,
 * 1 EXCEPTION HERE
 * But If we have different classes that uses this method and
 * they don't have an interface of object we want to pass to the method, then we don't have a change to pass the object.
 * In this case we should not change the method signature, because we don't have ability to pass
 * the same object with the same interface from other classes.
 * ------------------------------------------------------------------------------------------
 * ode example is from refactoring guru course but with my changes.
 */
class Room {
    // ...
    public boolean withinPlan(HeatingPlan plan) {
        int low = getLowestTemp();
        int high = getHighestTemp();
        return plan.withinRange(low, high);
    }

    private int getHighestTemp() {
        return 2;
    }

    private int getLowestTemp() {
        return 1;
    }
}