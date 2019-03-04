package ru.matevosyan.traversing;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TraversingTreeTest {

    @Test
    public void when_Then() {
        Tree<Integer> tree = new Tree<>();
        int actual = -1;
        int expected = 5;

        tree.put(1);
        tree.put(3);
        tree.put(5);
        tree.put(6);
        tree.put(2);

        Optional<Integer> optional = tree.get(5);
        if (optional.isPresent()) {
            actual = optional.get();
        }

        assertThat(actual, is(expected));

    }
}