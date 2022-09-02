package ru.matevosyan.searching;

import java.util.Objects;

public class BinarySearchRecursive implements Searchable<Integer, Integer> {

    @Override
    public Integer search(Integer[] array, Integer element) {
        int left = 0;
        int right = array.length - 1;
        return this.binaryRecursive(array, element, left, right);
    }

    private Integer binaryRecursive(Integer[] array, Integer element, int left, int right) {
        Integer result = -1;
        int middle;

        if (left > right) {
            return result;
        }

        middle = (left + right) / 2;

        if (Objects.equals(array[middle], element)) {
            result =  array[middle];
        } else if (array[middle] > element) {
            this.binaryRecursive(array, element, left, middle - 1);
        } else {
            this.binaryRecursive(array, element, middle + 1, right);
        }
        return result;
    }
}
