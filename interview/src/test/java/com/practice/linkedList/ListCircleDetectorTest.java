package com.practice.linkedList;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ListCircleDetectorTest {

    /**
     * Cycle in the list.
     * 1 2 3 4 5 3 7 9.
     *
     */
    @Test
    public void whenHasCycleThenReturnTru() {
        ListCircleDetector<Integer> list = new ListCircleDetector<>();

        ListCircleDetector.Node<Integer> root = new ListCircleDetector.Node<>(1);
        ListCircleDetector.Node<Integer> node2 = new ListCircleDetector.Node<>(2);
        ListCircleDetector.Node<Integer> node3 = new ListCircleDetector.Node<>(3);

        root.setNext(node2);
        node2.setNext(node3);
        node3.setNext(root);

        boolean hasCircle = list.hasCircle(root);

        assertThat(hasCircle, is(true));
    }
}
