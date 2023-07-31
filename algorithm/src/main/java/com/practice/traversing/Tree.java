package com.practice.traversing;

import java.util.Optional;


public class Tree<V extends Comparable<V>> {
    private Entry<V> root;
    private int size = 0;

    Tree() {
    }

    public Entry<V> getRoot() {
        return root;
    }

    protected class Entry<V> {
        V value;
        Entry<V> left;
        Entry<V> right;
        Entry<V> parent;

        Entry(V value, Entry<V> parent) {
            this.value = value;
            this.parent = parent;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Entry<?> entry = (Entry<?>) o;

            return value != null ? value.equals(entry.value) : entry.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    public Optional<V> put(V value) {

        Optional<V> v = Optional.empty();
        Entry<V> p = null;
        if (this.root == null) {
            this.root = new Entry<>(value, null);
            this.size = 1;
            return Optional.empty();
        } else {
            int cmp = 0;
            Entry<V> parent = this.root;
            Comparable<? super V> vCmp = value;
            if (vCmp != null) {
                do {
                    p = parent;
                    cmp = vCmp.compareTo(parent.value);
                    if (cmp < 0) {
                        parent = parent.left;
                    } else if (cmp > 0) {
                        parent = parent.right;
                    } else {
//                        parent.setValue(value);
                        break;
                    }
                } while (parent != null);
            }

            Entry<V> entry = new Entry<>(value, parent);
            if (cmp < 0) {
                p.left = entry;
            } else if (cmp > 0) {
                p.right = entry;
            }

            size++;
        }
        return v;
    }

    public Optional<V> get(V value) {
        Entry<V> parent = this.root;
        int compare;
        if (parent == null) {
            return Optional.empty();
        } else {
            while (parent != null) {
                compare = value.compareTo(parent.value);
                if (compare < 0) {
                    parent = parent.left;
                } else if (compare > 0) {
                    parent = parent.right;
                } else {
                    return Optional.of(parent.value);
                }
            }
        }
        return Optional.empty();
    }
}
