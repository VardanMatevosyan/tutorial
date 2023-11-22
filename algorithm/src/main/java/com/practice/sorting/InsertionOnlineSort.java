package com.practice.sorting;

import java.util.List;
import java.util.ArrayList;

/**
 * Modification of an Insertion sort to use a List and insert by one element.
 * This is like an Online adding and sorting.
 * In this case:
 * Best case O(n)
 * Worst case O(n)
 * Time complexity O(1) because of 3 variables which constant always even length increases. Algorithm
 * properties: - Stable: {1, a}, {3, p}, {8, g} {3, e}   ---->   {1, a} {3, p}, {3, e}, {8, g} - In
 * Place: no addition memory or variables needed to process the sorting - Online: can sort by adding
 * more elements in the array without resorting the rest of elements.
 *
 * @param <T> type of the element.
 */
public class InsertionOnlineSort<T> extends InsertionSort<T> implements Sortable<T> {

  private final List<T> data;

  public InsertionOnlineSort(List<T> data) {
    this.data = data;
  }

  public InsertionOnlineSort() {
    this.data = new ArrayList<>(128);
  }

  public List<T> sort(T element) {
    if (element instanceof Comparable) {
      if (data.isEmpty()) {
        data.add(element);
        return data;
      }

      if (data.size() == 1) {
        T first = data.get(0);
        if (((Comparable) element).compareTo(first) < 0) {
          data.set(1, first);
          data.set(0, element);
          return data;
        }
        data.add(element);
        return data;
      }

      int j = data.size() - 1;
      while (j >= 0 && (((Comparable) data.get(j)).compareTo(element) > 0)) {
        if (j == data.size() - 1) {
          data.add(j + 1, data.get(j));
        } else {
          data.set(j + 1, data.get(j));
        }
        j--;
      }
      if (j == data.size() - 1) {
        data.add(j + 1, element);
      } else {
        data.set(j + 1, element);
      }

    }
    return data;
  }

}
