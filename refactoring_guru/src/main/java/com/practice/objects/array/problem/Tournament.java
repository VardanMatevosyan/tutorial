package com.practice.objects.array.problem;

/**
 * Problem
 * If we are using an array to store different data, like for example in our case
 * at index 0 we store the football club name and at index 1 the number.
 * But we would end up debugging and searching the bug for weeks, because
 * at index 0 we know that Liverpool is the football club name, because we know what Liverpool
 * represents for us, but if there would be some other value for example HBA1.
 * What is HBA1? Gene? You would say yes we work with genes, and we know what is it.
 * But HBA1 can be the name of disease, and that what would cause the hours of wasted time.
 * For example if we look at value at index 1 in our row field,
 * the 15 can't tell us what is 15 is it total of CL wins or something else.
 * ---------------------------------------------------------------------------------------------------
 * Solution is to use objects instead of array to store the data with self-explanatory field names.
 * ---------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Tournament {
    String[] row = new String[2];

    Tournament() {
        row[0] = "Liverpool";
        row[1] = "15";
    }
    public void displayScore() {
        String name = row[0];
        int score = Integer.parseInt(row[1]);
        // ...
    }
}