package com.practice.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    List<String> list = List.of("first", "second", "3");
    Set<String> set = Set.of("first", "second", "3");

    String[] arrayFromList = list.toArray(String[]::new);
    String[] arrayFromSet = set.toArray(String[]::new);

    System.out.println("An array from list - " + Arrays.toString(arrayFromList));
    System.out.println("An array from set - " + Arrays.toString(arrayFromSet));
  }


  public void compareTwoSets() {
    List<String> list = List.of("first", "second", "3");
    Set<String> set = Set.of("first", "second", "3");
    Set<String> hashSet = new HashSet<>();
    hashSet.add("first");
    hashSet.add("second");
    hashSet.add("3");

    // hashCode of the value from the List.of()
    System.out.println("list - "  + " value is " + list.get(0) +  " hashcode is " + list.get(0) .hashCode());

    // hashCode of the value from the Set.of()
    Iterator<String> iterator = set.iterator();
    iterator.next();
    iterator.next();
    String next = iterator.next();
    System.out.println("set - " + " value is " + next +  " hashcode is " + next.hashCode());

    // hashCode of the value from the hashSet
    Iterator<String> iteratorHashSet = hashSet.iterator();
    iteratorHashSet.next();
    String nextIteratorHashSet = iteratorHashSet.next();
    System.out.println("HashSet - " + " value is " + nextIteratorHashSet +  " hashcode is " + nextIteratorHashSet.hashCode());
    System.out.println();

    // Resume
    // All the hashcodes are the same for the same value, but Set.of() and new HashSet()
    // have different algorithm to determine the index of the bucket to store the value.
    // The result of the output:
    //    list -  value is first hashcode is 97440432
    //    set -  value is first hashcode is 97440432
    //    HashSet -  value is first hashcode is 97440432
    //    An array from list - [first, second, 3]
    //    An array from set - [second, 3, first]
    //    An array hash set- [3, first, second]
  }
}