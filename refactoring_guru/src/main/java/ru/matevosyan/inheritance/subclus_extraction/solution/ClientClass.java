package ru.matevosyan.inheritance.subclus_extraction.solution;

public class ClientClass {
    void someClientMethod() {
        Employee kent = new Employee(50);
        JobItem j1 = new LaborItem(5, kent);
        JobItem j2 = new PartsItem(15, 10);
        int total = j1.getTotalPrice() + j2.getTotalPrice();
    }
}
