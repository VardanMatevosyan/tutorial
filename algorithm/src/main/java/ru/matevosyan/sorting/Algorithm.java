package ru.matevosyan.sorting;

/**
 * Strategy executor for Sortable algorithm.
 * @param <T> Type.
 */
public class Algorithm<T> {
    private final Sortable<T> sortable;

    Algorithm(final Sortable<T> sortable) {
        this.sortable = sortable;
    }

    /**
     * Execute sorting method from Sortable object.
     * @param array an array.
     * @return sorted array.
     */
    public T[] execute(T[] array) {
        return (T[]) this.sortable.sort(array);
    }
}
