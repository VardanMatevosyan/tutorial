package com.practice.collections.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

  /**
  *         5
  *       /  \
  *      4    10
  *       \
  *        30
  **/
  @Test
  public void test_computeInOrder_shouldAcceptConsumerAndFillTheListWithInOrderData() {
    Set<Integer> set = new SimpleTreeSet<>();
    set.add(5);
    set.add(4);
    set.add(10);
    set.add(30);

    List<Integer> inOrderInts = new ArrayList<>();
    List<Integer> expectedInts = Arrays.asList(4, 5, 10, 30);

    set.computeInOrder(inOrderInts::add);

    assertThat(4, is(set.size()));
    for (int i = 0; i < expectedInts.size(); i++) {
      assertThat(inOrderInts.get(i), is(expectedInts.get(i)));
    }
  }

  @Test
  public void test_contains_whenValueIsPresentInTheTreeSet_shouldReturnTrue() {
    Set<Integer> set = new SimpleTreeSet<>();
    set.add(5);
    set.add(55);

    boolean containsSecond = set.contains(55);
    boolean containsRoot = set.contains(5);
    boolean notContains = set.contains(123123123);

    assertThat(containsSecond, is(true));
    assertThat(containsRoot, is(true));
    assertThat(notContains, is(false));
  }

}