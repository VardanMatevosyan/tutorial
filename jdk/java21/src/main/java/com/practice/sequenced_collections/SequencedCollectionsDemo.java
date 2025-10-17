package com.practice.sequenced_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SequencedCollection;

public class SequencedCollectionsDemo {

  public static void main(String[] args) {
    SequencedCollection<Integer> list = new ArrayList<>();
    list.add(12);
    list.add(2);
    list.add(5);

    System.out.println("Get first element: " + list.getFirst());
    System.out.println("Get last element: " + list.getLast());

    list.addFirst(100);
    list.addLast(0);
    System.out.println("After adding first and last elements: " + list);

    Collection<Integer> reversed = list.reversed();
    System.out.println("After reversing the list: " + reversed);
  }
}
