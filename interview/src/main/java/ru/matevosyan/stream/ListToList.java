package ru.matevosyan.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToList {
    public List<Integer> convertStringLengthFromTheListToElementOfTheList(final List<String> strings) {
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

    public List<Integer> convertListOfStringToListOfIntegersJava7(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : strings) {
            int numberInt = Integer.parseInt(number);
            numbers.add(numberInt);
        }
        return numbers;
    }

    public List<Integer> convertListOfStringToListOfIntegersJava8(List<String> strings) {
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
