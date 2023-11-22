package com.practice.sorting;

/**
 * Insertion sort:
 * Best case time complexity - O(n)
 * Worst case time complexity - O(n*n)
 * Memory complexity O(1) because of 3 variables which constant always even length increases.
 * Algorithm properties:
 *  - Stable: {1, a}, {3, p}, {8, g} {3, e}   ---->   {1, a} {3, p}, {3, e}, {8, g}
 *  - In Place: no addition memory or variables needed to process the sorting
 *  - Online: can sort by adding more elements in the array without resorting the rest of elements.
 * @param <T> type of the element.
 */
public class InsertionSort<T> implements Sortable<T> {

  public InsertionSort() {
  }

  public T[] sort(T[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] instanceof Comparable) {
        T temp = array[i];
        int j = i - 1;
        while (j > 0 && (((Comparable) array[j]).compareTo(temp) > 0)) {
          array[j + 1] = array[j];
          j--;
        }
        array[j + 1] = temp;
      }
    }
    return array;
  }

}
