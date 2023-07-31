package com.practice.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ListToListTest {

    @Test
    public void convertListOfStringToListOfIntegersJava7() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(2);
        expectedNumbers.add(3);

        ListToList listToList = new ListToList();
        List<Integer> numbers = listToList.convertListOfStringToListOfIntegersJava7(strings);
       assertArrayEquals(numbers.toArray(), expectedNumbers.toArray());
    }

    @Test
    public void convertListOfStringToListOfIntegersJava8() {
        List<String> strings = Arrays.asList("1", "2", "3");
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);
        ListToList listToList = new ListToList();
        List<Integer> numbers = listToList.convertListOfStringToListOfIntegersJava8(strings);
        assertArrayEquals(numbers.toArray(), expectedNumbers.toArray());
    }

    @Test
    public void whenStingElementLengthIsEqualsToNumbersOfTheReturnedElementOfTheListAtTheSamePosition() {
        ListToList listToList = new ListToList();
        List<Integer> convert = listToList.convertStringLengthFromTheListToElementOfTheList(Arrays.asList("a", "ab", "abc", "abcd"));
        Integer actual = convert.get(0);
        Integer expected = 1;

        assertEquals(actual, expected);
    }
}
