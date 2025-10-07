package com.practice.traversing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * Testing Iterative Depth First Search traversing.
 *   Tree example for this test:
 * TREE variable visualization
 *       1
 *        \
 *         3
 *        / \
 *       2   5
 *          /
 *         4
 *
 */
public class IterativeDepthFirstSearchTest {

  private static final Tree<Integer> TREE = new Tree<>();

  static {
    TREE.put(1);
    TREE.put(3);
    TREE.put(5);
    TREE.put(4);
    TREE.put(2);
  }

  @Test
  public void when_usePreOrderDFS_then_checkResult() {
    List<Integer> expected = Arrays.asList(1, 3, 2, 5, 4);

    IterativeDepthFirstSearch<Integer> dfs = new IterativeDepthFirstSearch<>();
    List<Integer> actual = dfs.preOrder(TREE);

    Assert.assertArrayEquals(expected.toArray(), actual.toArray());
  }


  @Test
  public void when_useInOrderDFS_then_checkResult() {
    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

    IterativeDepthFirstSearch<Integer> dfs = new IterativeDepthFirstSearch<>();
    List<Integer> actual = dfs.inOrder(TREE);

    Assert.assertArrayEquals(expected.toArray(), actual.toArray());
  }


  @Test
  public void when_usePostOrderDFS_then_checkResult() {
    List<Integer> expected = Arrays.asList(2, 4, 5, 3, 1);

    IterativeDepthFirstSearch<Integer> dfs = new IterativeDepthFirstSearch<>();
    List<Integer> actual = dfs.postOrder(TREE);

    Assert.assertArrayEquals(expected.toArray(), actual.toArray());
  }


}