package ru.matevosyan.inheritance.subclus_extraction.solution;

class LaborItem extends JobItem {
    private Employee employee;

    LaborItem(int quantity, Employee employee) {
        super(quantity);
        this.employee = employee;
    }
    public Employee getEmployee() {
        return employee;
    }
    @Override public int getUnitPrice() {
        return employee.getRate();
    }
}
