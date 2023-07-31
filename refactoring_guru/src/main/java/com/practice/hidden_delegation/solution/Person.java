package com.practice.hidden_delegation.solution;

class Person {
    private Department department;

    public void setDepartment(Department arg) {
        department = arg;
    }
    public Person getManager() {
        return department.getManager();
    }
}



// Somewhere in client code
//manager = john.getManager();
