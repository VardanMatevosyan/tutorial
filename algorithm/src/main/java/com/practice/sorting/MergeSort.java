package com.practice.sorting;

import java.util.Arrays;

/**
 * MergeSort for merging two sorted arrays.
 */
public class MergeSort implements Sortable<Integer> {
    @Override
    public Integer[] sort(Integer[] array) {
        if (array.length < 2) {
            return array;
        }
        Integer[] leftPart = sortLeftHalf(array);
        Integer[] rightPart = sortRightHalf(array);
        return merge(leftPart, rightPart);
    }

    /**
     * Sort right half of the array.
     * @param array created during each recursing call.
     * @return sorted right half of the array.
     */
    private Integer[] sortRightHalf(Integer[] array) {
        int middle = array.length / 2;
        Integer[] rightSubArray = subArray(array, middle, array.length);
        return sort(rightSubArray);
    }

    /**
     * Sort left half of the array.
     * @param array created during each recursing call.
     * @return sorted left half of the array.
     */
    private Integer[] sortLeftHalf(Integer[] array) {
        int middle = array.length / 2;
        Integer[] leftSubArray = subArray(array, 0, middle);
        return sort(leftSubArray);
    }

    /**
     * Create sub array from given array.
     * @param array created during each recursing call.
     * @param from where to start.
     * @param to where to end.
     * @return sub array.
     */
    private static Integer[] subArray(Integer[] array, int from, int to) {
        return Arrays.copyOfRange(array, from, to);
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
        int fai = 0;
        int sai = 0;
        int rai = 0;

        while (fai < first.length && sai < second.length) {
            result[rai++] = first[fai] < second[sai] ? first[fai++] : second[sai++];
        }
        if (fai < first.length) {
            System.arraycopy(first, fai, result, rai, first.length - fai);
        } else if (sai < second.length) {
            System.arraycopy(second, sai, result, rai, second.length - sai);
        }

        return result;
    }

}

