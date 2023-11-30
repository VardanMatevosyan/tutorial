package com.practice.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PalindromeTest {

  @Test
  public void when_sentencesIsPalindromeCheckMethod_thenShouldReturnTrue() {
    Palindrome palindrome = new Palindrome();
    String sentences = "SOLOS";
    boolean actual = palindrome.check1(sentences);

    assertThat(actual, is(true));
  }

  @Test
  public void when_sentencesIsPalindrome_thenShouldReturnTrue() {
    Palindrome palindrome = new Palindrome();
    String sentences = "SOLOS";

    boolean actual = palindrome.isPalindrome2(sentences);

    assertThat(actual, is(true));
  }

  @Test
  public void when_sentencesIsNotPalindrome_thenShouldReturnFalse() {
    Palindrome palindrome = new Palindrome();
    String sentences = "SOLO";

    boolean actual = palindrome.isPalindrome2(sentences);

    assertThat(actual, is(false));
  }

  @Test
  public void when_stringIsNotPalindromeWithNonAlphabeticalCharsUsingIsPalindrome3_thenFalse() {
    Palindrome palindrome = new Palindrome();
    String sentences = "SOL_O:";

    boolean actual = palindrome.isPalindrome3(sentences);

    assertThat(actual, is(false));
  }

  @Test
  public void when_stringIsNotPalindromeWithNonAlphabeticalCharsUsingIsPalindrome4_thenFalse() {
    Palindrome palindrome = new Palindrome();
    String sentences = "S~OL_O:";

    boolean actual = palindrome.isPalindrome4(sentences);

    assertThat(actual, is(false));
  }

  @Test
  public void when_stringIsPalindromeWithNonAlphabeticalCharsUsingIsPalindrome4_thenTrue() {
    Palindrome palindrome = new Palindrome();
    String sentences = "S~OL_O:S";

    boolean actual = palindrome.isPalindrome4(sentences);

    assertThat(actual, is(true));
  }

  @Test
  public void when_stringIsPalindromeWithNonAlphabeticalCharsUsingIsPalindrome3_thenTrue() {
    Palindrome palindrome = new Palindrome();
    String sentences = "S~OL_O:S";

    boolean actual = palindrome.isPalindrome3(sentences);

    assertThat(actual, is(true));
  }


}
