package com.practice.collections.map;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class CustomHashMapTest {


  @Test
  public void test_putValueByKey_whenPutToMap() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("1", "111");
    map.put("2", "222");

    assertThat(map.size(), Matchers.is(2));
    assertThat(map.isEmpty(), Matchers.is(false));
  }

  @Test
  public void test_putValueByKeyWithSameKey_whenPutToMap_thenShouldReturnSizeOfOneNode() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("Aa", "222");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
  }


  @Test
  public void test_putValueByKeyWithSameHash_whenPutToMap_thenElementsShouldBeAddedAnyway() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BB", "222");

    assertThat(map.size(), Matchers.is(2));
    assertThat(map.isEmpty(), Matchers.is(false));
  }

  /**
   * Aa, BB, aAa index is always the same -
   * When putting only Aa and BB when invoking get method by aAa the map should return null
   * and not the last found node value return by the calculated index.
   * This issue may occur when wrong algorithm used to found node with the same index and key.
   */
  @Test
  public void test_getValueByKey_whenThereIsTwoNodeInOneBucket_thenReturnCorrectValue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BB", "222");

    assertThat(map.size(), Matchers.is(2));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.get("BB"), Matchers.is("222"));
    assertThat(map.get("Aa"), Matchers.is("111"));
    assertThat(map.get("aAa"), Matchers.isEmptyOrNullString());

  }

  @Test
  public void test_getValueByKey_whenThereIsOneNodeInTheBucket_thenReturnCorrectValue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.get("Aa"), Matchers.is("111"));
  }

  @Test
  public void test_containsKey_whenThereIsOneNodeInTheBucket_thenReturnTrue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.containsKey("Aa"), Matchers.is(true));
  }

  @Test
  public void test_containsKey_whenNoKeyPresentInTheMap_thenReturnFalse() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.containsKey("BB"), Matchers.is(false));
  }

  @Test
  public void test_containsValue_whenOneNodeInTheMap_thenReturnTrue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.containsValue("111"), Matchers.is(true));
  }

  @Test
  public void test_containsValue_whenFewNodeIsInTheSameBucketWithNeededValue_thenReturnTrue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BB", "222");

    assertThat(map.size(), Matchers.is(2));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.containsValue("222"), Matchers.is(true));
  }

  @Test
  public void test_containsValue_whenNoNodeValuePresent_thenReturnFalse() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BB", "222");

    assertThat(map.size(), Matchers.is(2));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(map.containsValue("333"), Matchers.is(false));
  }

  @Test
  public void test_removeByKey_whenKeyPresent_thenReturnDeletedValue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BBBBB", "555555");

    String removed = map.remove("Aa");

    assertThat(map.size(), Matchers.is(1));
    assertThat(map.isEmpty(), Matchers.is(false));
    assertThat(removed, Matchers.is("111"));
  }

  @Test
  public void test_removeByKey_whenKeyPresentInListOfNodes_thenReturnDeletedValue() {
    Map<String, String> map = new CustomHashMap<>();
    map.put("Aa", "111");
    map.put("BB", "222");
    map.put("aAa", "333");

    String removed = map.remove("BB");
    String removedSecond = map.remove("aAa");
    String removedThird = map.remove("Aa");

    assertThat(map.size(), Matchers.is(0));
    assertThat(map.isEmpty(), Matchers.is(true));
    assertThat(removed, Matchers.is("222"));
    assertThat(removedSecond, Matchers.is("333"));
    assertThat(removedThird, Matchers.is("111"));
  }
}