package ru.matevosyan.hidden_delegation.problem;

/**
 * Problem here is that we need to know all hierarchy of the main class.
 * For example client code as in the comments below the class can invoke getters many times
 * if there would be complex class hierarchy.
 * ---------------------------------------------------------------------------------------
 * Solution is -  in the Person class return not Department but the manager itself.
 * ----------------------------------------------------------------------------------------
 * The Code example is from refactoring guru course.
 */
class Person {
    private Department department;

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department arg) {
        department = arg;
    }
}




// Somewhere in client code
//manager = john.getDepartment().getManager();
