package com.practice.strings;

public class Convert {
    public String reverse(String str) {
        int len = str.length();
        char[] chars = new char[len];
        char[] array = str.toCharArray();
        for (int i = 0; i < len; i++) {
            chars[i] = array[len - i - 1];
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Convert reverse = new Convert();
        String string = "ABC v";
        String reversed = reverse.reverse(string);
        System.out.println(reversed);
    }
}
