package com.practice.collections.linkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.LinkedList;
import org.junit.Test;

public class MiddleElementTest {

    @Test
    public void whenPassLinkedListThenGetTheMiddleElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int expected = 2;
        MiddleElement<Integer> middleElementGetter = new MiddleElement<>();
        Integer actual = middleElementGetter.getMiddleElement(list);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenPassLinkedListThenGetTheMiddleElementBySlowAndFastPointers() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int expected = 4;
        MiddleElement<Integer> middleElementGetter = new MiddleElement<>();
        Integer actual = middleElementGetter.getMiddleElementBySlowAndFastPointers(list);

        assertThat(actual, is(expected));
    }
}
