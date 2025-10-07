package com.practice.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Iterative Depth First Search traversing.
 * Pre-order, In order, Post order.
 *
 * @param <V> the type parameter
 */
public class IterativeDepthFirstSearch<V extends Comparable<V>> {

  public List<V> preOrder(Tree<V> tree) {
    List<V> result = new ArrayList<>();
    if (isNull(tree.getRoot())) {
      return result;
    }
    Deque<Tree.Entry<V>> deque = new ArrayDeque<>();
    deque.add(tree.getRoot());

    while (!deque.isEmpty()) {
      Tree.Entry<V> entry = deque.pop();
      result.add(entry.value);

      if (nonNull(entry.right)) {
        deque.push(entry.right);
      }
      if (nonNull(entry.left)) {
        deque.push(entry.left);
      }
    }

    return result;
  }

  public List<V> inOrder(Tree<V> tree) {
    List<V> result = new ArrayList<>();

    if (isNull(tree.getRoot())) {
      return result;
    }

    Deque<Tree.Entry<V>> deque = new ArrayDeque<>();
    Tree.Entry<V> current = tree.getRoot();

    while (!deque.isEmpty() || nonNull(current)) {

      while (nonNull(current)) {
        deque.push(current);
        current = current.left;
      }

      Tree.Entry<V> pop = deque.pop();
      result.add(pop.value);
      current = pop.right;
    }
    return result;
  }

  public List<V> postOrder(Tree<V> tree) {
    List<V> result = new ArrayList<>();
    if (isNull(tree)) {
      return result;
    }

    Deque<Tree.Entry<V>> stack1 = new ArrayDeque<>();
    Deque<Tree.Entry<V>> stack2 = new ArrayDeque<>();
    stack1.push(tree.getRoot());


    while (!stack1.isEmpty()) {
      Tree.Entry<V> entry = stack1.pop();
      stack2.push(entry);

      if (nonNull(entry.left)) {
        stack1.push(entry.left);
      }
      if (nonNull(entry.right)) {
        stack1.push(entry.right);
      }
    }

    while (!stack2.isEmpty()) {
      result.add(stack2.pop().value);
    }
    return result;
  }


}
