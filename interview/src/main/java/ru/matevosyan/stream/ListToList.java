package ru.matevosyan.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToList {
    public List<Integer> convert(final List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

    public List<Integer> convertWithFilter(final Collection<String> strings) {
        return strings.stream().filter(ch -> ch.length() > 2).map(String::length).collect(Collectors.toList());
    }

    public List<Integer> convertWithFilterAndLimit(final Collection<String> strings) {
        Stream<String> stream = strings.stream();
        Stream<String> stringStream = stream.filter(ch -> ch.length() > 2);
        Stream<Integer> integerStream = stringStream.map(String::length);
        Stream<Integer> limit = integerStream.limit(1);
        List<Integer> collect = limit.collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        ListToList listToList = new ListToList();
        List<Integer> convert = listToList.convert(Arrays.asList("a", "ab", "abc", "abcd"));
        Integer integer = convert.get(0);
        System.out.println("First value " + integer);
        convert.forEach(System.out::println);
    }
}
