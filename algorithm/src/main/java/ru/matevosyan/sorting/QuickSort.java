package ru.matevosyan.sorting;

/**
 * QuickSort sort an array using quick sort algorithm.
 */
public class QuickSort implements Sortable<Integer> {

    @Override
    public Integer[] sort(Integer[] array) {
        return this.quickSorting(array, 0, array.length - 1);
    }

    /**
     * Quick sort algorithm using recursion.
     * @param array an array.
     * @param left index.
     * @param right index.
     * @return an array.
     */
    private Integer[] quickSorting(Integer[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        Integer pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);

        quickSorting(array, left, index - 1);
        quickSorting(array, index, right);
        return array;
    }

    /**
     * Get index to separate an array.
     *
     * Example
     * 1 2 8 4 3
     * 1 2 3 4 8
     * use one swap.
     *
     * @param subArray separated array.
     * @param left index.
     * @param right index.
     * @param pivot element
     * @return separated index.
     */
    private int partition(Integer[] subArray, int left, int right, int pivot) {
        while (left <= right) {
            while (subArray[left] < pivot) {
                left++;
            }
            while (subArray[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(subArray, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * swap two elements.
     * @param subArray an array.
     * @param left index.
     * @param right index.
     */
    private void swap(final Integer[] subArray, final int left, final int right) {
        int tmp = subArray[left];
        subArray[left] = subArray[right];
        subArray[right] = tmp;
    }
}
