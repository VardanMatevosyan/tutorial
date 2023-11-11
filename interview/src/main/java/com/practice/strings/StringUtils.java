package com.practice.strings;

import static java.util.Objects.isNull;

public class StringUtils {

    public static void main(String[] args) {
        StringUtils converter = new StringUtils();
        String string = "ABC v";

        String reversed = converter.reverse(string);
        System.out.println(reversed);

        String reversedStr = converter.reverseStr(string);
        System.out.println(reversedStr);

        String excludedChars = converter.deleteChars("Asus", "s");
        System.out.println(excludedChars);

    }

    public String reverse(String str) {
        int len = str.length();
        char[] chars = new char[len];
        char[] array = str.toCharArray();
        for (int i = 0; i < len; i++) {
            chars[i] = array[len - i - 1];
        }
        return String.valueOf(chars);
    }

    public String reverseStr(String original) {
        int len = original.length();
        char[] chars = original.toCharArray();
        char[] result = new char[len];
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            result[i] = chars[j];
        }
        return String.valueOf(result);
    }

    /**
     * Remove characters from the first String which are present in the second String.
     * @param from first String from which the characters would be deleted.
     * @param chars second string that contains all characters that is candidate for deleting the same char from the first string.
     * @return string with deleted chars that presents in the second string.
     */
    public String deleteChars(String from, String chars) {
        if (isNull(chars) || chars.isEmpty()) {
            return from;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < from.length(); i++) {
            String charFrom = String.valueOf(from.charAt(i));
            if (!chars.contains(charFrom)) {
                builder.append(charFrom);
            }
        }
        return builder.toString();
    }

}
