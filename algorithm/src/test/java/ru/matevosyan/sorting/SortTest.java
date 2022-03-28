package ru.matevosyan.sorting;

import org.junit.Test;
import java.util.Arrays;

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

    private void sortBy(Sortable<Integer> sortable, Integer[] actual, Integer[] expected, String massage) {
        Algorithm<Integer> algorithm = new Algorithm<>(sortable);

        System.out.println("Before " + massage + ": ");
        Arrays.asList(actual).forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        Integer[] result = algorithm.execute(actual);

        System.out.println("After " + massage + ": ");
        Arrays.asList(result).forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        System.out.println("=======================");

        assertThat(result, is(expected));
    }
}
