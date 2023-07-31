package com.practice.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyUsedHashtags {

    public static void main(String[] args) {
        List<String> twits = new ArrayList<>();
        twits.add("#Java or #Scala");
        twits.add("#Java or #C++");
        twits.add("#Spring is the best framework for java ever ))");
        List<String> hashTags = getHashTags(twits);
        System.out.println(hashTags);
    }

    public static List<String> getHashTags(List<String> twits) {
        Map<String, Long> hashTagsFrequency = getHashTagsFrequencyMap(twits);
        return getSortedHashTagsByFrequency(hashTagsFrequency);
    }

    private static List<String> getSortedHashTagsByFrequency(Map<String, Long> hashTagsFrequency) {
        return hashTagsFrequency.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Map<String, Long> getHashTagsFrequencyMap(List<String> twits) {
        return twits.stream()
                .map(twit -> twit.split(" "))
                .flatMap(Stream::of)
                .filter(s -> s.startsWith("#"))
                .map(s -> s.replace("#", ""))
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    }
}
