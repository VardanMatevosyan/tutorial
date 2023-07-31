package com.practice.searching;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchTest {
    @Test
    public void whenPassBinaryArrayAndElementToSearchThenGetElementYouAreSearchingFor() {
        Integer expected = 6;
        Searchable<Integer, Integer> searchable = new BinarySearchIterative();

        Integer actual = searchable.search(new Integer[]{2, 4, 6, 8, 11, 12, 15}, expected);

        assertThat(actual, is(expected));
    }
}
