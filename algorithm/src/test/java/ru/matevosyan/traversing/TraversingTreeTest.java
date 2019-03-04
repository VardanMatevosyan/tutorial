package ru.matevosyan.traversing;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Testing Depth First Search traversing.
 */
public class TraversingTreeTest {

    /**
     *     TREE
     *     root
     *      1
     *           3
     *        2      5
     *             4
     *
     */
    @Test
    public void whenUseDFSPreInPostOrderTraversingThenPrintTheResult() {
        Tree<Integer> tree = new Tree<>();

        int actual = -1;
        int expected = 5;

        tree.put(1);
        tree.put(3);
        tree.put(5);
        tree.put(4);
        tree.put(2);

        Optional<Integer> optional = tree.get(5);
        if (optional.isPresent()) {
            actual = optional.get();
        }
        DepthFirstSearch dfs = new DepthFirstSearch(tree);
        System.out.println("Pre order DFS traversing");
        dfs.preOrder();
        System.out.println("In order DFS traversing");
        dfs.inOrder();
        System.out.println("Post order DFS traversing");
        dfs.postOrder();

        assertThat(actual, is(expected));

    }
}