package com.practice.sorting;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortTest {

    @Test
    public void whenPassArrayOfIntegersThenGetTheSortedArray() {
        this.sortBy(new BubbleSort(), new Integer[]{1, 4, 7, 3, 5}, new Integer[]{1, 3, 4, 5, 7}, "Bubble sorting");
    }

    @Test
    public void whenPassArrayThenSortItByMergeSorting() {
        this.sortBy(new MergeSort(), new Integer[]{1, 5, 3, 4}, new Integer[]{1, 3, 4, 5}, "Merge sorting");
    }

    @Test
    public void whenPassArrayThenSortItByQuickSorting() {
        this.sortBy(new QuickSort(), new Integer[]{1, 2, 8, 4, 3}, new Integer[]{1, 2, 3, 4, 8}, "Quick sorting");
    }

    @Test
    public void whenPassArrayThenSortItByInsertionSorting() {
        this.sortBy(new InsertionSort(),
            new Integer[]{1, 2, 8, 4, 3}, new Integer[]{1, 2, 3, 4, 8}, "Insertion sorting");
    }


    @Test
    public void whenPassArrayThenSortItByInsertionOnlineSorting() {
        List<Integer> expected = List.of(-100, 0, 1, 2, 3, 4, 5, 8, 99);
        InsertionOnlineSort<Integer> insertionOnlineSort = new InsertionOnlineSort<>();

        insertionOnlineSort.sort(1);
        insertionOnlineSort.sort(2);
        insertionOnlineSort.sort(8);
        insertionOnlineSort.sort(4);
        insertionOnlineSort.sort(3);
        insertionOnlineSort.sort(0);
        insertionOnlineSort.sort(5);
        insertionOnlineSort.sort(-100);
        List<Integer> result = insertionOnlineSort.sort(99);

        System.out.println("Insertion online sorting: ");
        result.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        System.out.println("=======================");

        assertThat(result, is(expected));
    }

    private void sortBy(Sortable<Integer> sortable, Integer[] actual, Integer[] expected, String massage) {

        System.out.println("Before " + massage + ": ");
        Arrays.asList(actual).forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Integer[] result = sortable.sort(actual);

        System.out.println("After " + massage + ": ");
        Arrays.asList(result).forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        System.out.println("=======================");

        assertThat(result, is(expected));
    }
}
