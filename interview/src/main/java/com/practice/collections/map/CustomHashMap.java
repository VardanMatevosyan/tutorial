package com.practice.collections.map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Objects;

// TODO need to add TreeNode population when list of node >= 7
public class CustomHashMap<K, V> implements Map<K, V> {

  private Node<K,V>[] table;
  private int size;
  private int threshold;
  private int loadFactor;

  CustomHashMap() {
    this.table = new Node[8];
  }

  CustomHashMap(int capacity) {
    this.table = new Node[capacity];
  }

  @Override
  public V put(K key, V value) {
    int hash = hash(key);
    int index = calculateIndex(hash, table.length);

    if (isNull(table[index])) {
      table[index] = new Node<>(key, value, hash, null);
      size++;
    } else {
      Node<K, V> node = table[index];
      V oldValue = node.value;

      if (node.hash == hash && (Objects.equals(node.key, key)) ) {
        node.value = value;
      } else {
        while (nonNull(node.next)) {
          node = node.next;
        }
        node.next = new Node<>(key, value, hash, null);
        size++;
      }

      return oldValue;
    }

    return null;
  }

  @Override
  public V get(K key) {
    Node<K, V> node = getNode(key);
    return nonNull(node) ? node.value : null;
  }

  @Override
  public boolean containsKey(K key) {
    return nonNull(getNode(key));
  }

  @Override
  public boolean containsValue(V value) {
    for (Node<K, V> node : table) {
      if (nonNull(node) && node.value.equals(value)) {
        return true;
      }
      while (nonNull(node) && nonNull(node.next)) {
        node = node.next;
        if (node.value.equals(value)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public V remove(K key) {
    int index = calculateIndex(hash(key), table.length);
    Node<K, V> node = table[index];

    if (isNull(node)) {
      return null;
    }

    if (isNull(node.next)) {
      table[index] = null;
      size--;
      return node.value;
    }
    while (nonNull(node.next)) {
      Node<K, V> temp = node;
      node = node.next;
      if (Objects.equals(node.key, key)) {
        temp.next = node.next;
        size--;
        return node.value;
      }
    }
    return null;
  }

  private Node<K, V> getNode(K key) {
    Node<K, V> node = table[calculateIndex(hash(key), table.length)];
    if (isNull(node)) {
      return null;
    }
    if (Objects.equals(node.key, key)) {
      return node;
    }
    while (nonNull(node.next)) {
      node = node.next;
      if (Objects.equals(node.key, key)) {
        break;
      }
    }
    return Objects.equals(node.key, key) ? node : null;
  }

  public static int calculateIndex(int hash, int tableCapacity) {
    return hash & (tableCapacity - 1);
  }

  public static int hash(Object key) {
    if (nonNull(key)) {
      int h = key.hashCode();
      return h ^ (h >>> 16);
    }
    return 0;
  }


  static class Node<K, V> {
    final int hash;
    final K key;
    V value;
    Node<K, V> next; // this used in compute related methods

    Node(K key, V value, int hash, Node<K, V> next) {
      this.key = key;
      this.value = value;
      this.hash = hash;
      this.next = next;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node<?, ?> node = (Node<?, ?>) o;
      return Objects.equals(key, node.key) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }
  }
}
