package com.practice.collections.map;

public interface Map<K, V> {

  V put(K key, V value);
  V get(K key);
  boolean containsKey(K key);
  boolean containsValue(V value);
  int size();
  boolean isEmpty();
  V remove(K key);

}

