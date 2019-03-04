package ru.matevosyan.polindrom;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void when_Then() {
        Palindrome palindrome = new Palindrome();
        String sentences = "SOLOS";
        boolean actual = palindrome.check(sentences);

        assertThat(actual, is(true));
    }

}