package ru.matevosyan.objects.arguments.case1.problem;

class HeatingPlan {
    private TempRange range;
    public boolean withinRange(int low, int high) {
        return (low >= range.getLow() && high <= range.getHigh());
    }
}
