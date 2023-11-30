package com.practice.strings;

/**
 * Palindrome class. Check if sentences is palindrome or not.
 */
public class Palindrome {

  public Palindrome() {
  }

  /**
   * DABBAD and CIVIC and SOLOS is the palindrome.
   *
   * @param sentences as String.
   * @return true if sentences is the palindrome.
   */
  public boolean check1(String sentences) {
    int pFirst = 0;
    int pSecond = sentences.length() - 1;

    if (sentences.isEmpty()) {
      return false;
    }

    while (pFirst <= pSecond) {
      char cFirst = sentences.charAt(pFirst++);
      char cSecond = sentences.charAt(pSecond--);
      if (cFirst != cSecond) {
        return false;
      }
    }
    return true;
  }

  /**
   * This approach does not accept non-alphabetical characters.
   *
   * @param sentence string.
   * @return false if string is empty, true is it is a palindrome
   */
  public boolean isPalindrome2(String sentence) {
    if (sentence.isEmpty()) {
      return false;
    }
    char[] chars = sentence.toCharArray();
    for (int i = 0; i < sentence.length(); i++) {
      if (chars[i] != chars[sentence.length() - i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method better it accept non-alphabetical chars and whitespaces anywhere in the string.
   * Simple working approach
   *
   * @param s string.
   * @return true if contains only whitespace and is palindrome, else false.
   */
  public boolean isPalindrome3(String s) {

    s = prepareString(s);
    if (s.isEmpty()) {
      return true;
    }

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length / 2; i++) {
      if (chars[i] != chars[chars.length - i - 1]) {
        return false;
      }
    }

    return true;

  }

  private String prepareString(String str) {
    return str
        .replaceAll("\\W|\\s|:|_", "")
        .toLowerCase()
        .trim();
  }

  /**
   * The fastest approach. The best approach is using Character class. to ask if it is a digit or
   * letter and just increase the index is much faster than even prepare all string using regex
   * expression at ones at the beginning
   *
   * @param s string
   * @return true if contains only whitespace and is palindrome, else false.
   */
  public boolean isPalindrome4(String s) {

    if (s == null || s.isEmpty()) {
      return true;
    }

    int start = 0, end = s.length() - 1;

    while (start < end) {
      char startChar = Character.toLowerCase(s.charAt(start));
      char endChar = Character.toLowerCase(s.charAt(end));

      if (!Character.isLetterOrDigit(startChar)) {
        start++;
      } else if (!Character.isLetterOrDigit(endChar)) {
        end--;
      } else if (startChar != endChar) {
        return false;
      } else {
        start++;
        end--;
      }
    }
    return true;
  }

}
