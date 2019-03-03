package ru.matevosyan.searching;

/**
 * Searchable interface for searching element in an array.
 * @param <T> element type.
 */
public interface Searchable<T, E> {
    /**
     * Search element in the given array.
     * @param array an array.
     * @return sorted array.
     */
    E search(T[] array, E element);
}
