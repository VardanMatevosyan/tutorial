package ru.matevosyan.searching;

import java.util.Objects;

public class BinarySearchIterative implements Searchable<Integer, Integer> {
    private Integer result = -1;

    @Override
    public Integer search(Integer[] array, Integer element) {
        return this.binaryIterative(array, element);
    }

    private Integer binaryIterative(Integer[] array, Integer element) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        while (left <= right) {
            middle = left + ((right - left) / 2);

            if (Objects.equals(array[middle], element)) {
                return array[middle];
            } else if (array[middle] < element) {
                left = middle + 1;
            } else if (array[middle] > element) {
                right = middle - 1;
            }
        }
        return this.result;
    }
}
