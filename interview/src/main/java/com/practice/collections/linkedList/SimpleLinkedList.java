package com.practice.collections.linkedList;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  @Override
  public void add(T element) {
    if (isNull(element)) {
      return;
    }
    addNodeToTail(new Node<>(element));
  }

  private void addNodeToTail(Node<T> node) {
    if (size > 0) {
      tail.next = node;
    } else {
      head = node;
    }
    tail = node;
    size++;
  }

  @Override
  public void add(int index, T element) {

    if (isNull(element)) {
      return;
    }

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    Node<T> node = new Node<>(element);

    if (index == 0) {
      if (size == 0) {
        addNodeToTail(node);
      } else  {
        addNodeToHead(node);
      }
    }

    if (index > 0) {
      Node<T> previousNode = head;
      for (int i = 0; i < index - 1; i++) {
        previousNode = previousNode.next;
      }
      node.next = previousNode.next;
      previousNode.next = node;
      size++;
    }

  }

  @Override
  public void set(int index, T element) {
    Node<T> node = getNode(index);
    node.value = element;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index > size || size == 0 || index == size) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      return getFirst();
    }

    if (index == size - 1) {
      return getLast();
    }

    Node<T> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode.value;
  }

  @Override
  public T getFirst() {
    checkSize();
    return head.value;
  }

  @Override
  public T getLast() {
    checkSize();
    return tail.value;
  }

  @Override
  public T remove(int index) {
    checkSizeAndIndexBounds(index);

    Node<T> removedNode = head;
    if (index == 0) {
      head = head.next;
    }

    if (index > 0) {
      Node<T> previousNode = head;
      for (int i = 0; i < index - 1; i++) {
        previousNode = previousNode.next;
      }

      if (index == size - 1) {
        removedNode = tail;
        previousNode.next = null;
        tail = previousNode;
      } else {
        removedNode = previousNode.next;
        previousNode.next = previousNode.next.next;
      }

    }
    size--;
    return removedNode.value;
  }

  @Override
  public boolean contains(T element) {
    if (size == 0) {
      return false;
    }
    Node<T> currentNode = head;

    if (size > 0) {
      for (int i = 0; i < size; i++) {
        if (nonNull(currentNode.next) && currentNode.value.equals(element)) {
          return true;
        }
        currentNode = currentNode.next;
      }
    }

    return false;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }


  @SafeVarargs
  public static <T> SimpleLinkedList<T> of(T... elements) {
    SimpleLinkedList<T> linkedList = new SimpleLinkedList<>();
    for (T element : elements) {
      linkedList.add(element);
    }
    return linkedList;
  }

  private void addNodeToHead(Node<T> node) {
    if (size > 0) {
      node.next = head;
      head = node;
    } else {
      head = node;
      tail = node;
    }
    size++;
  }

  @Override
  public void reverse() {
    Node<T> futureTail = head;
    Node<T> nextNode = null;
    Node<T> prevNode = null;

    while (head != null) {
      nextNode = head.next;
      head.next = prevNode;
      prevNode = head;
      head = nextNode;
    }
    head = prevNode;
    tail = futureTail;
  }

  private Node<T> getNode(int index) {
    if (index < 0 || index > size || size == 0 || index == size) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      return head;
    }

    if (index == size - 1) {
      return tail;
    }

    Node<T> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode;
  }

  private void checkSizeAndIndexBounds(int index) {
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    checkIndexBounds(index);
  }

  private void checkIndexBounds(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void checkSize() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
  }

  private static class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
      this.value = value;
    }
  }
}
