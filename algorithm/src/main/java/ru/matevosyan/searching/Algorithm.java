package ru.matevosyan.searching;

/**
 * Strategy executor for Searchable algorithm.
 * @param <T> Type.
 * @param <E> Element.
 */
public class Algorithm<T, E> {
    private final Searchable<T, E> searchable;

    Algorithm(final Searchable<T, E> searchable) {
        this.searchable = searchable;
    }

    /**
     * Execute search method from Searchable object.
     * @param array an array.
     * @param element element.
     * @return element from an array.
     */
    public E execute(T[] array, E element) {
        return this.searchable.search(array, element);
    }


}
