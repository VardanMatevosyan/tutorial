package ru.matevosyan.bobocode.train;

public class IntMax {

    public static int findMax(int[] array) {
        int result = array[0];
        for (int j : array) {
            if (j > result) {
                result = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int max = findMax(new int[]{1, 6, 4});
        System.out.println(max);
    }
}
