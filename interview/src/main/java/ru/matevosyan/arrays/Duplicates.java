package ru.matevosyan.arrays;

import java.util.Arrays;
import java.util.BitSet;

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

    public static void main(String[] args) {
        Duplicates duplicates = new Duplicates();
        int[] ints = {1, 2, 3, 4, 3};
        boolean hasDuplicate = duplicates.hasDuplicate(ints);
        System.out.println(String.format(" An array %s has duplicate ? %b",
                Arrays.toString(ints),
                hasDuplicate));

    }
}
