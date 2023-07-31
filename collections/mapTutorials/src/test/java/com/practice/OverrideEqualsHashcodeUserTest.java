package com.practice;

import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.NavigableMap;
import java.util.TreeMap;


/**
 * Was created to test OverrideEqualsHashCodeUserTest class.
 * Created on 07.05.2017.
 * @author Matevosian Vardan
 * @version 1.0
 */


public class OverrideEqualsHashcodeUserTest {
    @Test
    public void whenCreateNavigableMapCheckAFewMethods() {

        Calendar c = new GregorianCalendar(2017, Calendar.JUNE, 8);
        OverrideEqualsHashcodeUser first = new OverrideEqualsHashcodeUser("first", 1, c);
        OverrideEqualsHashcodeUser second = new OverrideEqualsHashcodeUser("second", 2, c);
        OverrideEqualsHashcodeUser third = new OverrideEqualsHashcodeUser("third", 3, c);
        OverrideEqualsHashcodeUser fourth = new OverrideEqualsHashcodeUser("fourth", 4, c);
        OverrideEqualsHashcodeUser fifth = new OverrideEqualsHashcodeUser("fifth", 5, c);

        NavigableMap<OverrideEqualsHashcodeUser, Object> map = new TreeMap<>(getComparator());

        System.out.println("============================Put and out===========================================");
        map.put(first, "User1");
        map.put(second, "User2");
        map.put(third, "User3");
        map.put(fourth, "User4");
        map.put(fifth, "User5");
        map.forEach((key, value) -> System.out.println(key.getName() + " " + value));

        System.out.println("================================Descending Map=======================================");
        map = map.descendingMap();
        map.forEach((key, value) -> System.out.println(key.getName() + " " + value));

        System.out.println("================================headMap=======================================");
        NavigableMap<OverrideEqualsHashcodeUser, Object> navMapHead = map.headMap(second, true);
        navMapHead.forEach((key, value) -> System.out.println(key.getName() + " " + value));

        System.out.println("================================tailMap=======================================");
        NavigableMap<OverrideEqualsHashcodeUser, Object> navMapTail = map.tailMap(second, true);
        navMapTail.forEach((key, value) -> System.out.println(key.getName() + " " + value));

        System.out.println("================================merges to change====================");
        map.merge(second,  "change", (value, newValue) -> value = newValue);
        map.forEach((key, value) -> System.out.println(key.getName() + " " + value));

        System.out.println("================================tailMap for last not include====================");
        map = map.tailMap(fourth, false);
        System.out.println(map);
    }

    private static Comparator<OverrideEqualsHashcodeUser> getComparator() {
        return (o1, o2) -> o1.getName().compareTo(o2.getName());
    }
}
