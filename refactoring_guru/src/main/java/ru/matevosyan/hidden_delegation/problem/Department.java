package ru.matevosyan.hidden_delegation.problem;

class Department {
    private String chargeCode;
    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }
    public Person getManager() {
        return manager;
    }

    //…
}
