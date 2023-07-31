package com.practice.arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Duplicates {

    /**
     * XOR table for bitmap mark.
     * INPUT	| OUTPUT
     * A	B	| A XOR B
     * 0	0	|    0
     * 0	1	|    1
     * 1	0	|    1
     * 1	1	|    0
     * BAD IDEA because of memory leak maxSize = 178_626_964 is max value fo boolean array.
     * 1 element of boolean weight 8 bytes.
     * GOOD IDEA use BitSet for leas memory leaking. max size for BitSet is 1_429_012_400.
     * @param numbers array of numbers.
     * @return true if an array has duplicate.
     */
    @SuppressWarnings("InnerAssignment")
    public boolean hasDuplicate(int[] numbers) {
        int maxSize = 1_429_012_400;
        BitSet bits = new BitSet(maxSize);
        for (int i : numbers) {
            boolean value = bits.get(i);
            boolean mark = value ^= true;
            bits.set(i, mark);
            if (!(mark)) {
                return true;
            }
        }
        return false;
    }

    /**
     * In Java 8 Stream, filter with Set.Add() is the fastest algorithm to find duplicate elements,
     * because it loops only one time.
     * @param numbers array og numbers.
     * @return if the list contains duplicate.
     */
    public boolean hasDuplicateJava8V1(int[] numbers) {
        Set<Integer> setOfTheNumbers = new HashSet<>();
        return IntStream.of(numbers).filter(n -> !setOfTheNumbers.add(n)).findAny().isPresent();
    }

    /**
     * In Java 8 Stream, filter with grouping to map is not bad to use but a little bit slower then using Set.
     * @param numbers array og numbers.
     * @return if the list contains duplicate.
     */
    public boolean hasDuplicateJava8V2(int[] numbers) {
        return IntStream.of(numbers).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .anyMatch(m -> m.getValue() > 1);
    }

    /**
     * The Collections.frequency is the slowest because it compares each item
     * with a list – Collections.frequency(list, i).
     * If we increase the size of the list, the performance will get slower.
     * @param numbers array og numbers.
     * @return if the list contains duplicate.
     */
    public boolean hasDuplicateJava8V3(int[] numbers) {
        List<Integer> listOfNumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());
        return listOfNumbers.stream().anyMatch(n -> Collections.frequency(listOfNumbers, n) > 1);
    }

    public static void main(String[] args) {
        Duplicates duplicates = new Duplicates();
        int[] ints = {1, 2, 3, 4, 5};
        boolean hasDuplicate = duplicates.hasDuplicateJava8V3(ints);
        System.out.println(String.format(" An array %s has duplicate? %s",
                Arrays.toString(ints),
                hasDuplicate ? " Yes" : "No"));

    }
}
