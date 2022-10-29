package ru.matevosyan.objects.array.solution;

/**
 * Problem
 * Solution is to use objects instead of array to store the data with self-explanatory field names.
 * ---------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Tournament {
    Performance row = new Performance();

    Tournament() {
        row.setName("Liverpool");
        row.setScore("15");
    }
    public void displayScore() {
        String name = row.getName();
        int score = row.getScore();
        // ...
    }
}
