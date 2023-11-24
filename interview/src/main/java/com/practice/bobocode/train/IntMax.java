package com.practice.bobocode.train;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntMax {

    public static int findMax(int[] array) {
        int result = array[0];
        for (int j : array) {
            if (j > result) {
                result = j;
            }
        }
        return result;
    }

    public static int findMax(List<Integer> integers) {
        return integers.stream()
            .max(Integer::compareTo)
//            .max(Comparator.comparing(Function.identity(), Integer::compareTo))
//            .max(Comparator.comparing(Function.identity()))
//            .max(Comparator.comparingInt(value -> value))
//            .max(Comparator.naturalOrder())
            .orElse(0);
    }


    public static int findMaxWithToIntStream(List<Integer> integers) {
        return integers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
    }

    public static void main(String[] args) {
        List<Integer> integers = getIntegers(100000);
        int[] integersArray = getIntegersArray(100000);

        long start = System.nanoTime();
        int max = findMax(integersArray);
        long end = ((System.nanoTime() - start) / 1_000_000);

        long start2 = System.nanoTime();
        int maxFromList = findMax(integers);
        long end2 = ((System.nanoTime() - start2) / 1_000_000);

        long start3 = System.nanoTime();
        int maxFromListWithToIntStream = findMaxWithToIntStream(integers);
        long end3 = ((System.nanoTime() - start3) / 1_000_000);


        System.out.println("max is " + max + " last " + end + "ms");
        System.out.println("maxFromList is " + maxFromList + " last " + end2 + "ms");
        System.out.println("maxFromListWithToIntStream is " + maxFromListWithToIntStream + " last " + end3 + "ms");

    }

    private static int[] getIntegersArray(int capasity) {
        return IntStream.rangeClosed(0, capasity).toArray();
    }

    private static List<Integer> getIntegers(Integer capasity) {
        return IntStream.rangeClosed(0, capasity)
            .boxed()
            .collect(Collectors.toList());
    }
}
