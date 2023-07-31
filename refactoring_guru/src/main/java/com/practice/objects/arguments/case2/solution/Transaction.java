package com.practice.objects.arguments.case2.solution;

import java.util.Date;

class Transaction {
    private Date chargeDate;
    private double value;

    Transaction(double value, Date chargeDate) {
        this.value = value;
        this.chargeDate = chargeDate;
    }
    public Date getDate() {
        return chargeDate;
    }
    public double getValue() {
        return value;
    }
}
