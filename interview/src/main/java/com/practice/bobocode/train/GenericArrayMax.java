package com.practice.bobocode.train;

import lombok.Getter;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericArrayMax {

  public static void main(String[] args) {
    Integer[] integers = {5531, 4382, 3233, 2234, 9, 0, 5532};
    String[] strings = {"Var", "Mar", "Tar", "Y should the last"};

    int maxInt = findMax(integers);
    String maxString = findMax(strings);
    System.out.println("Max int value is " + maxInt);
    System.out.println("Max String value is " + maxString);
    System.out.println();

    int maxWithComparatorIntWithoutComparator = findMax(integers, null);
    String maxWithComparatorStringWithoutComparator = findMax(strings, null);
    System.out.println("Max without comparator int value is " + maxWithComparatorIntWithoutComparator);
    System.out.println("Max without comparator String value is " + maxWithComparatorStringWithoutComparator);
    System.out.println();

    int maxWithComparatorInt = findMax(integers, Comparator.naturalOrder());
    String maxWithComparatorString = findMax(strings, Comparator.naturalOrder());
    System.out.println("Max with comparator int value is " + maxWithComparatorInt);
    System.out.println("Max with comparator String value is " + maxWithComparatorString);
    System.out.println();

    int maxWithComparatorIntNaturalOrder = findMax(integers, Comparator.reverseOrder());
    String maxWithComparatorStringNaturalOrder = findMax(strings, Comparator.reverseOrder());
    System.out.println("Max with comparator should be min int value is " + maxWithComparatorIntNaturalOrder);
    System.out.println("Max with comparator should be min String value is " + maxWithComparatorStringNaturalOrder);

    int max = IntStream.rangeClosed(1, Math.max(10, 20))
        .map(i -> i * 10)
        .max()
        .orElse(-1);
    System.out.println("Max from IntStream is " + max);

    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    testOwnComparator();

  }

  private static void testOwnComparator() {
    var test1 = new TestObj(1, "First");
    var test2 = new TestObj(2, "Second");
    var test3 = new TestObj(3, "Third");


    Stream.of(test1, test2, test3)
        .max(ownCompare(TestObj::getValue))
        .ifPresent(e -> System.out.println("Max by value: " + e.description));

    Stream.of(test1, test2, test3)
        .max(comparing(TestObj::getValue))
        .ifPresent(e -> System.out.println("Max by value: " + e.description));
  }

  private static <T, R extends Comparable<? super R>> Comparator<T> ownCompare(Function<? super T, ? extends R> cf) {
    return (e1, e2) -> cf.apply(e1).compareTo(cf.apply(e2));
  }


  private static <T extends Comparable<? super T>> T findMax(T[] array) {
    T result = array[0];
    for (T item : array) {
      if (item.compareTo(result) > 0) {
        result = item;
      }
    }
    return result;
  }

  private static <T extends Comparable<? super T>> T findMax(T[] array, Comparator<? super T> c) {
    if (isNull(c)) {
      return findMax(array);
    }
    T result = array[0];
    for (T item : array) {
      if (c.compare(item, result) > 0) {
        result = item;
      }
    }
    return result;
  }


  @Getter
  static class TestObj {
    final Integer value;
    final String description;

    TestObj(Integer value, String description) {
      this.value = value;
      this.description = description;
    }

  }

}
