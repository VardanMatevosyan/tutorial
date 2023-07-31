package com.practice;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Converter {

  public Converter() {
  }

  public Map<String, Set<String>> convertAndReturnMap(List<Map<String, Object>> resultListMap) {
    return resultListMap
            .stream()
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.mapping(entry -> String.valueOf(entry.getValue()), Collectors.toSet())));
  }
}
