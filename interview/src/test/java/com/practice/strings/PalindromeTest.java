package com.practice.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PalindromeTest {

    @Test
    public void when_sentencesIsPalindromeCheckMethod_thenShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        String sentences = "SOLOS";
        boolean actual = palindrome.check(sentences);

        assertThat(actual, is(true));
    }

    @Test
    public void when_sentencesIsPalindrome_thenShouldReturnTrue() {
        Palindrome palindrome = new Palindrome();
        String sentences = "SOLOS";

        boolean actual = palindrome.isPalindrome(sentences);

        assertThat(actual, is(true));
    }

    @Test
    public void when_sentencesIsNotPalindrome_thenShouldReturnFalse() {
        Palindrome palindrome = new Palindrome();
        String sentences = "SOLO";

        boolean actual = palindrome.isPalindrome(sentences);

        assertThat(actual, is(false));
    }

}
