package com.practice.arrays;

public class ArrayUtil {


    /**
     * Both arrays should be sorted otherwise it is not possible to merged and sort an arrays at on integration.
     * and in this case we would have to sort each array first before merging it.
     * first array  = 1, 3, 5
     * second array = 6, 8, 9
     * result array = 1, 3, 5, 6, 8, 9
     *
     * @param first  array.
     * @param second array.
     * @return merged sorted array.
     */
    public int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int i = 0;
        while (i < result.length) {

            if (first[firstArrayIndex] < second[secondArrayIndex]) {
                result[i++] = first[firstArrayIndex++];
            } else {
                result[i++] = second[secondArrayIndex++];
            }

            if (firstArrayIndex == first.length) {
                while (secondArrayIndex < second.length) {
                    result[i++] = second[secondArrayIndex++];

                }
            }
            if (secondArrayIndex == second.length) {
                while (firstArrayIndex < first.length) {
                    result[i++] = first[firstArrayIndex++];
                }
            }

        }
        return result;
    }

}
