package ru.matevosyan.methods.util.solution;

import java.util.Date;

class DateUtils extends Date {
    DateUtils(String dateString) {
        super(dateString);
    }
    DateUtils(Date arg) {
        super(arg.getTime());
    }
    public Date nextWeek() {
        return new Date(getYear(), getMonth(), getDate() + 7);
    }
}