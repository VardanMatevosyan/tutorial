package com.practice.collections.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Comparator;
import org.junit.Test;

public class SimpleTreeSetTest {


  @Test
  public void test_tree_without_comparator() {
    Set<Integer> set = new SimpleTreeSet<>();
    set.add(5);
    set.add(4);
    set.add(10);
    set.add(30);

    assertThat(4, is(set.size()));
  }

  @Test
  public void test_tree_with_comparator() {
    Set<Integer> set = new SimpleTreeSet<>(Comparator.reverseOrder());
    set.add(5);
    set.add(4);
    set.add(10);
    set.add(30);

    assertThat(4, is(set.size()));
  }

}