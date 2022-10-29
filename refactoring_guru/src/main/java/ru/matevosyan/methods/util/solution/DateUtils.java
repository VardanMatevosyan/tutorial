package ru.matevosyan.methods.util.solution;

import java.util.Date;

class DateUtils extends Date {
    public DateUtils(String dateString) {
        super(dateString);
    }
    public DateUtils(Date arg) {
        super(arg.getTime());
    }
    public Date nextWeek() {
        return new Date(getYear(), getMonth(), getDate() + 7);
    }
}