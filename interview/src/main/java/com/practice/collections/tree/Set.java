package com.practice.collections.tree;

import java.util.Iterator;

public interface Set<E> extends Iterable<E> {

  int size();

  boolean isEmpty();

  boolean contains(E element);

  boolean add(E element);

  boolean remove(Object element);

  void clear();

  Iterator<E> iterator();

}
