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
  private static final String ABC_KEY = "ABC";
  private static final String DEF_KEY = "DEF";
  private static final String ABC_VALUE_123 = "123";
  private static final String ABC_VALUE_124 = "124";
  private static final String ABC_VALUE_125 = "125";
  private static final String DEF_VALUE_126 = "126";
  private static final String DEF_VALUE_127 = "127";
  private static final List<String> FIRST_ACTUAL = Arrays.asList(ABC_VALUE_123, ABC_VALUE_124, ABC_VALUE_125);
  private static final List<String> SECOND_ACTUAL = Arrays.asList(DEF_VALUE_126, DEF_VALUE_127);
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
    verifyResults(resultMap);
  }

  private void verifyResults(Map<String, Set<String>> resultMap) {
    resultMap.forEach((key, value) -> {
      System.out.println("Key - " + key + " | Value - " + value);
    });

    resultMap.forEach((key, value1) -> {
      List<Map<String, Object>> mapStream = data.stream().filter(map ->
              map.containsKey(key)).collect(Collectors.toList());
      mapStream.forEach(map -> {
        String value = (String) map.get(key);
        assertTrue((ConverterTest.FIRST_ACTUAL.contains(value) && !ConverterTest.SECOND_ACTUAL.contains(value))
            || (!ConverterTest.FIRST_ACTUAL.contains(value) && ConverterTest.SECOND_ACTUAL.contains(value)));
      });
    });
  }
}
