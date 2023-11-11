package com.practice.collections.tree;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class SimpleTreeSet<E extends Comparable<? super E>> implements Set<E> {

  private Entry<E> root;
  private final Comparator<? super E> comparator;
  private int size = 0;

  public SimpleTreeSet() {
    comparator = null;
  }

  public SimpleTreeSet(Comparator<? super E> comparator) {
    this.comparator = comparator;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0 && nonNull(root);
  }

  @Override
  public boolean contains(E element) {
    return nonNull(getEntry(element));
  }

  @Override
  public boolean add(E element) {
    Entry<E> parent = root;

    if (isNull(parent)) {
      createRootEntry(element);
      size++;
      return true;
    } else {
      Entry<E> p;
      int compared;
      if (isNull(comparator)) {
        do {
          p = parent;
          compared = element.compareTo(parent.value);
          if (compared < 0) {
            parent = parent.left;
          } else if (compared > 0) {
            parent = parent.right;
          } else {
            return false;
          }
        } while (nonNull(parent));
      } else {
        do {
          p = parent;
          compared = comparator.compare(element, parent.value);
          if (compared < 0) {
            parent = parent.left;
          } else if (compared > 0) {
            parent = parent.right;
          } else {
            return false;
          }
        } while (nonNull(parent));
      }

      addEntry(element, p, compared < 0);
      size++;
    }
    return false;
  }

  private void addEntry(E element, Entry<E> parent, boolean addToLeft) {
    Entry<E> entry = new Entry<>(element, parent);
    if (addToLeft) {
      parent.left = entry;
    } else {
      parent.right = entry;
    }
  }

  @Override
  public boolean remove(Object element) {
    // todo implement later
    return false;
  }

  @Override
  public void clear() {
    root = null;
  }

  @Override
  public Iterator<E> iterator() {
    // todo implement later
    return null;
  }

  @Override
  public void computeInOrder(Consumer<E> consumer) {
    Entry<E> parent = root;
    inOrderTravers(parent, consumer);
  }

  private void inOrderTravers(Entry<E> parent, Consumer<E> consumer) {
    if (isNull(parent)) {
      return;
    }
    inOrderTravers(parent.left, consumer);
    consumer.accept(parent.value);
    inOrderTravers(parent.right, consumer);
  }

  private void createRootEntry(E element) {
    root = new Entry<>(element, null);
  }

  private Entry<E> getEntry(E element) {
    Entry<E> parent = root;
    int compared;

    if (isNull(comparator)) {
      do {
        compared = element.compareTo(parent.value);

        if (compared == 0) {
          return parent;
        } else if (compared < 0) {
          parent = parent.left;
        } else {
          parent = parent.right;
        }

      } while (nonNull(parent));
    } else {
      do {
        compared = comparator.compare(element, parent.value);

        if (compared == 0) {
          return parent;
        } else if (compared < 0) {
          parent = parent.left;
        } else {
          parent = parent.right;
        }

      } while (nonNull(parent));
    }
    return null;
  }


  private static final class Entry<E> {

    E value;
    Entry<E> left;
    Entry<E> right;
    Entry<E> parent;

    public Entry(E value, Entry<E> parent) {
      this.value = value;
      this.parent = parent;
    }

    public boolean equals(Object o) {
      if (o instanceof Entry<?>) {
        return Objects.equals(o, this);
      }
      return false;
    }

    public int hashcode() {
      return this.value == null ? 0 : value.hashCode();
    }

  }
}
