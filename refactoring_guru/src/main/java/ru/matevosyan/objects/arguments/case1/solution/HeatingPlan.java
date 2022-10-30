package ru.matevosyan.objects.arguments.case1.solution;

class HeatingPlan {
    private TempRange range;
    public boolean withinRange(Room room) {
        return (room.getLowestTemp() >= range.getLow() && room.getHighestTemp() <= range.getHigh());
    }
}
