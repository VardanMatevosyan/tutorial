package com.practice.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class BreadthFirstSearch<V extends Comparable<V>> {
    private final ArrayDeque<Tree.Entry<V>> queue = new ArrayDeque<>();;
    private final List<V> values = new ArrayList<>();
    private final Tree.Entry<V> parent;

    public BreadthFirstSearch(final Tree<V> tree) {
        this.parent = tree.getRoot();
    }

    public List<V> traverse() {
        queue.addLast(this.parent);

        while (!queue.isEmpty()) {
            Tree.Entry<V> entry = queue.pollFirst();
            values.add(entry.value);

            if (nonNull(entry.left)) {
                this.queue.addLast(entry.left);
            }
            if (nonNull(entry.right)) {
                this.queue.addLast(entry.right);
            }

        }
        return values;
    }
}
