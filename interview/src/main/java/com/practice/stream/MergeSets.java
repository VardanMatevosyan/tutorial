package com.practice.stream;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSets {
  public static void main(String[] args) {
    Set<String> strNumbers = getImmutableSet("1", "2");
    Set<Integer> integers = getImmutableSet(1, 2);
    Set<String> mutableSet = getMutableSetWithNull();

    Set<?> mergedSets = mergeSets(strNumbers, mutableSet, integers);
    System.out.println("mergedSets : " + mergedSets);

    Set<Number> numbers = mergeStrSets(1, 4.5D, 4L);
    System.out.println("objSet : " + numbers);
  }

  private static Set<?> mergeSets(Set<?>... sets) {
    return Stream.of(sets)
        .flatMap(Collection::stream)
        .filter(Objects::nonNull)
        .collect(Collectors.toSet());
  }

  @SafeVarargs
  private static <T extends Number> Set<T> mergeStrSets(T... obj) {
    return Stream.of(obj)
        .filter(Objects::nonNull)
        .collect(Collectors.toSet());
  }

  private static HashSet<String> getMutableSetWithNull() {
    HashSet<String> objects = new HashSet<>();
    objects.add("asdf");
    objects.add(null);
    return objects;
  }

  @SafeVarargs
  private static <T> Set<T> getImmutableSet(T... strings) {
    return Set.of(strings);
  }

}
