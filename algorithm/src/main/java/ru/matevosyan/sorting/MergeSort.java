package ru.matevosyan.sorting;

import java.util.Arrays;

/**
 * MergeSort for merging two sorted arrays.
 */
public class MergeSort implements Sortable<Integer> {
    @Override
    public Integer[] sort(Integer[] array) {
        int len = array.length;
        int middle = len / 2;
        if (len < 2) {
            return array;
        }
        return merge(sort(Arrays.copyOfRange(array, 0, middle)),
                sort(Arrays.copyOfRange(array, middle, array.length)));
    }

    /**
     * Merge two arrays to one sorted array.
     * @param first array.
     * @param second array.
     * @return array of integers.
     */
    private Integer[] merge(Integer[] first, Integer[] second) {
        int size = first.length + second.length;
        Integer[] result = new Integer[size];
        int firPointer = 0;
        int secPointer = 0;
        int resPointer = 0;

        while (firPointer < first.length && secPointer < second.length) {
            result[resPointer++] = first[firPointer] < second[secPointer] ? first[firPointer++] : second[secPointer++];
        }
        if (firPointer < first.length) {
            System.arraycopy(first, firPointer, result, resPointer, first.length - firPointer);
        } else if (secPointer < second.length) {
            System.arraycopy(second, secPointer, result, resPointer, second.length - secPointer);
        }
        return result;
    }

}

