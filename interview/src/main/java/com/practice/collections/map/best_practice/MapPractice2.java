package com.practice.collections.map.best_practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class MapPractice2 {

  public static void main(String[] args) {
    List<String> strings = List.of("aaa", "b", "c", "aaa", "e");

    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    Map<String, Integer> simpleMap = convertToMapSimple(strings);
    simpleMap.forEach((k, v) -> System.out.print(k + ":" + v + " , "));
    System.out.println();

    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    Map<String, Integer> bettermap = convertToMapBetter(strings);
    bettermap.forEach((k, v) -> System.out.print(k + ":" + v + " , "));
    System.out.println();

    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    Map<String, Integer> betterStreamMap = convertToMapStreamBetter(strings);
    betterStreamMap.forEach((k, v) -> System.out.print(k + ":" + v + " , "));
    System.out.println();


  }

  private static Map<String, Integer> convertToMapSimple(List<String> strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      Integer count = map.get(str);
      if (nonNull(count)) {
        map.put(str, count + 1);
      } else {
        map.put(str, 1);
      }
    }
    return map;
  }

  private static Map<String, Integer> convertToMapBetter(List<String> strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      map.merge(str, 1, Integer::sum);
    }
    return map;
  }

  private static Map<String, Integer> convertToMapStreamBetter(List<String> strings) {
    return strings
            .stream()
            .collect(groupingBy(s -> s, summingInt(s -> 1)));
  }
}
