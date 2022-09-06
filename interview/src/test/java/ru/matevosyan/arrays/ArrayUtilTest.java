package ru.matevosyan.arrays;

import org.junit.Assert;
import org.junit.Test;


public class ArrayUtilTest {

    @Test
    public void test_whenTwoSortedArrays_thenShouldMergedTwoSortedArraysIntoOne() {
        int[] expected = new int[]{1, 3, 5, 6, 8, 9};
        int[] mergedArray = new ArrayUtil().merge(new int[]{1, 3, 5}, new int[]{6, 8, 9});
        Assert.assertArrayEquals(expected, mergedArray);
    }

    @Test
    public void test_whenTwoSortedArraysWithDifferentLength_thenShouldMergedTwoSortedArraysIntoOne() {
        int[] expected = new int[]{1, 3, 5, 7, 8, 12, 16};
        int[] mergedArray = new ArrayUtil().merge(new int[]{8, 12, 16}, new int[]{1, 3, 5, 7});
        Assert.assertArrayEquals(expected, mergedArray);
    }
}