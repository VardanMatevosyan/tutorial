package ru.matevosyan;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class ConverterTest {
  private final static String ABC_KEY = "ABC";
  private final static String DEF_KEY = "DEF";
  private final static String ABC_VALUE_123 = "123";
  private final static String ABC_VALUE_124 = "124";
  private final static String ABC_VALUE_125 = "125";
  private final static String DEF_VALUE_126 = "126";
  private final static String DEF_VALUE_127 = "127";
  private final static List<String> actual = Arrays.asList(ABC_VALUE_123, ABC_VALUE_124, ABC_VALUE_125);
  private final static List<String> actual2 = Arrays.asList(DEF_VALUE_126, DEF_VALUE_127);
  private final Converter converter = new Converter();
  private final List<Map<String, Object>> data = new ArrayList<>();

  @Before
  public void setUp() {
    data.add(Collections.singletonMap(ABC_KEY, ABC_VALUE_123));
    data.add(Collections.singletonMap(ABC_KEY, ABC_VALUE_124));
    data.add(Collections.singletonMap(ABC_KEY, ABC_VALUE_125));
    data.add(Collections.singletonMap(DEF_KEY, DEF_VALUE_126));
    data.add(Collections.singletonMap(DEF_KEY, DEF_VALUE_127));
  }

  @Test
  public void verifyTheDataFromTheListIsTheSameInTheMap() {
    Map<String, Set<String>> resultMap = converter.convertAndReturnMap(data);
    verifyResults(actual, actual2, resultMap);
  }

  @Test
  public void verifyTheDataWithColumnsFromTheListIsTheSameInTheMap() {
    Map<String, Set<String>> resultMap = converter.convertAndReturnMapWithColumnNames(data);
    verifyResults(actual, actual2, resultMap);
  }

  private void verifyResults(List<String> actual, List<String> actual2, Map<String, Set<String>> resultMap) {
    resultMap.forEach((key, value) -> {
      System.out.println("Key - " + key + " | Value - " + value);
    });

    resultMap.forEach((key, value1) -> {
      List<Map<String, Object>> mapStream = data.stream().filter(map ->
              map.containsKey(key)).collect(Collectors.toList());
      mapStream.forEach(map -> {
        String value = (String) map.get(key);
        assertTrue((actual.contains(value) && !actual2.contains(value)) ||
                (!actual.contains(value) && actual2.contains(value)));
      });
    });
  }
}
