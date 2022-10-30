package ru.matevosyan.methods.parametrization.problem;

public class ClientClass {
    public void someClientMethod(Employee employee) {
        if (employee.yearsOfExperience > 5) {
            if (employee.clients.size() > 10) {
                employee.promoteToManager();
            } else {
                employee.fivePercentRaise();
            }
        }
    }
}
