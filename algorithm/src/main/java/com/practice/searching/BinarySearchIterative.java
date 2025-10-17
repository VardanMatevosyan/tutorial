package com.practice.searching;

import java.util.Objects;

public class BinarySearchIterative implements Searchable<Integer, Integer> {

    @Override
    public Integer search(Integer[] array, Integer element) {
        return this.binaryIterative(array, element);
    }

    private Integer binaryIterative(Integer[] array, Integer element) {
        Integer result = -1;
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left <= right) {
            middle = getNewArrayMiddle(left, right);
            if (Objects.equals(array[middle], element)) {
                return array[middle];
            } else if (array[middle] < element) {
                left = incrementMiddle(middle);
            } else if (array[middle] > element) {
                right = decrementMiddle(middle);
            }
        }
        return result;
    }

    private static int decrementMiddle(int middle) {
        return middle - 1;
    }

    private static int incrementMiddle(int middle) {
        return middle + 1;
    }

    private static int getNewArrayMiddle(int left, int right) {
        return left + ((right - left) / 2);
    }
}
