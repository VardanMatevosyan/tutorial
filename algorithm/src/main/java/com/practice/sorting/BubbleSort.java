package com.practice.sorting;

/**
 * For bubble sort algorithm.
 */
public class BubbleSort implements Sortable<Integer> {

    /**
     * Bubble sort implementation.
     * Using first array for a full pass of each value in the array.
     * Using second array to compare the current item with each item.
     * @param array an array.
     */
    @Override
    public Integer[] sort(Integer[] array) {
        for (int count = 0; count < array.length - 1; count++) {
            for (int i = array.length - 1; i > count; i--) {
                if (array[i] < array[i - 1]) {
                    Integer temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }
}
