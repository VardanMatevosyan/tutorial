package com.practice.searching;

/**
 * Searchable interface for searching element in an array.
 * @param <T> an array element type.
 * @param <E> element type.
 */
public interface Searchable<T, E> {
    /**
     * Search element in the given array.
     * @param array an array.
     * @param element an element.
     * @return sorted array.
     */
    E search(T[] array, E element);
}
