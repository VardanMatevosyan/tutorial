package com.practice.arrays;

import java.util.Arrays;

public class Anagram {

  public static void main(String[] args) {
    String word = "anagram";
    String anagram = "nagaram";
    boolean isAnagram = isAnagram(word, anagram);
    System.out.println(word + " is anagram to " + anagram + " - " + isAnagram);
  }



  public static boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Arrays.sort(sChars);
    Arrays.sort(tChars);
    return Arrays.compare(sChars, tChars) == 0;
  }
}
