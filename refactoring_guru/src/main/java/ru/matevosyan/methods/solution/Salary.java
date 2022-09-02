package ru.matevosyan.methods.solution;

public class Salary {

    double raise(double salary, double percent) {
        return salary + (salary * (percent / 100));
    }

}
