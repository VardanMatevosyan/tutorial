package com.practice.traversing;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class Tree<V extends Comparable<V>> {
    private Entry<V> root;
    private int size = 0;

    public void put(V value) {
        Entry<V> p = null;
        if (this.root == null) {
            this.root = new Entry<>(value, null);
            this.size = 1;
        } else {
            int cmp = 0;
            Entry<V> parent = this.root;
          if (value != null) {
                do {
                    p = parent;
                    cmp = value.compareTo(parent.value);
                    if (cmp < 0) {
                        parent = parent.left;
                    } else if (cmp > 0) {
                        parent = parent.right;
                    } else {
                        break;
                    }
                } while (parent != null);

              Entry<V> entry = new Entry<>(value, parent);
              if (cmp < 0) {
                  p.left = entry;
              } else if (cmp > 0) {
                  p.right = entry;
              } else {
                  p.value = value;
                  return;
              }
              size++;
            }
        }
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

    protected static class Entry<V> {
        V value;
        Entry<V> left;
        Entry<V> right;
        Entry<V> parent;

        Entry(V value, Entry<V> parent) {
            this.value = value;
            this.parent = parent;
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

            return Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }
}
