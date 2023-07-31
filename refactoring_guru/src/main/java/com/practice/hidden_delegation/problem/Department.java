package com.practice.hidden_delegation.problem;

class Department {
    private String chargeCode;
    private Person manager;

    Department(Person manager) {
        this.manager = manager;
    }
    public Person getManager() {
        return manager;
    }

    //…
}
