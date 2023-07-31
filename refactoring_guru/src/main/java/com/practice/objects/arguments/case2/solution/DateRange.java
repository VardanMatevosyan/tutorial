package com.practice.objects.arguments.case2.solution;

import java.util.Date;

class DateRange {
    private final Date start;
    private final Date end;

    DateRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    public Date getStart() {
        return start;
    }
    public Date getEnd() {
        return end;
    }
    public boolean includes(Date arg) {
        return arg.compareTo(start) >= 0 && arg.compareTo(end) <= 0;
    }
}
