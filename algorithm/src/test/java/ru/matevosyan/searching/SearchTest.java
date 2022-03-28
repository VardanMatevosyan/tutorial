package ru.matevosyan.searching;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchTest {
    @Test
    public void whenPassBinaryArrayAndElementToSearchThenGetElementYouAreSearchingFor() {
        Searchable<Integer, Integer> searchable = new BinarySearchIterative();
        Algorithm<Integer, Integer> algorithm = new Algorithm<>(searchable);
        Integer expected = 6;
        Integer actual = algorithm.execute(new Integer[]{2, 4, 6, 8, 11, 12, 15}, expected);

        assertThat(actual, is(expected));
    }
}
