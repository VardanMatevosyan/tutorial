package ru.matevosyan.inheritance.subclus_extraction.solution;

class PartsItem extends JobItem {
    private int unitPrice;

    PartsItem(int quantity, int unitPrice) {
        super(quantity);
        this.unitPrice = unitPrice;
    }
    @Override public int getUnitPrice() {
        return unitPrice;
    }
}
