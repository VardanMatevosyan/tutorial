package matevosyan.palindrome;

import org.junit.Test;
import ru.matevosyan.palindrome.Palindrome;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PalindromeTest {

    @Test
    public void when_Then() {
        Palindrome palindrome = new Palindrome();
        String sentences = "SOLOS";
        boolean actual = palindrome.check(sentences);

        assertThat(actual, is(true));
    }

}