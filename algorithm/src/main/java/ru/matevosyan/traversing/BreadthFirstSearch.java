package ru.matevosyan.traversing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch<V extends Comparable<V>> {
    private final ArrayDeque<Tree.Entry> queue = new ArrayDeque<>();;
    private final List<V> values = new ArrayList<>();
    private final Tree.Entry parent;

    public BreadthFirstSearch(final Tree tree) {
        this.parent = tree.getRoot();
    }

    public List<V> search(V value) {
        queue.addLast(this.parent);

        while(queue.size() > 0) {
            Tree.Entry entry = queue.pollFirst();
            values.add((V) entry.value);
            if (entry.left != null) {
                this.queue.addLast(entry.left);
            }
            if (entry.right != null) {
                this.queue.addLast(entry.right);
            }
        }
        return values;
    }
}
