package com.practice.searching;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class BinarySearchRecursiveTest {


  @Test
  public void when_recursiveNotExistElementSearch_thenGetCorrectNegativeAnswer() {
    Integer expected = -1;
    Searchable<Integer, Integer> searchableRecursive = new BinarySearchRecursive();

    Integer cursiveActual = searchableRecursive.search(new Integer[]{1}, 8);

    assertThat(cursiveActual, is(expected));
  }

}