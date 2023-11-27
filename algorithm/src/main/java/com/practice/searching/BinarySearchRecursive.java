package com.practice.searching;

import java.util.Objects;

public class BinarySearchRecursive implements Searchable<Integer, Integer> {

    @Override
    public Integer search(Integer[] array, Integer element) {
        int left = 0;
        int right = array.length - 1;
        return binaryRecursive(array, element, left, right);
    }

    private Integer binaryRecursive(Integer[] array, Integer element, int left, int right) {
        int middle;

        if (left > right) {
            return -1;
        }

        middle = (left + right) / 2;

        if (Objects.equals(array[middle], element)) {
            return array[middle];
        } else if (array[middle] > element) {
            return binaryRecursive(array, element, left, middle - 1);
        } else {
            return binaryRecursive(array, element, middle + 1, right);
        }
    }
}
