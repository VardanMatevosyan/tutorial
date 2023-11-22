package com.practice.sorting;

/**
 * Sortable interface for sort an array.
 * @param <T> element type.
 */
public interface Sortable<T> {
    /**
     * sort the given array.
     * @param array an array to sort.
     * @return sorted array.
     */
    T[] sort(T[] array);
}
