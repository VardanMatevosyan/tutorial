package ru.matevosyan.palindrome;

/**
 * Palindrome class.
 * Check if sentences is palindrome or not.
 */
public class Palindrome {

    public Palindrome() {
    }

    /**
     * DABBAD and CIVIC and SOLOS is the palindrome.
     * @param sentences as String.
     * @return true if sentences is the palindrome.
     */
    public boolean check(String sentences) {
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
}
