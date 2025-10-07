package com.practice.traversing;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Testing Depth First Search traversing.
 */
public class TraversingTreeTest {

    /** DepthFirstSearch.
     *     TREE
     *     root
     *      1
     *           3
     *        2      5
     *             4
     * =========================
     * Expected result
     * Pre order DFS traversing
     * 1
     * 3
     * 2
     * 5
     * 4
     * In order DFS traversing
     * 1
     * 2
     * 3
     * 4
     * 5
     * Post order DFS traversing
     * 2
     * 4
     * 5
     * 3
     * 1
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
        allDfsTraversal(tree);

        assertThat(actual, is(expected));

    }

    /**
     * BreadthFirstSearch.
     *     TREE
     *     root
     *      1
     *           3
     *        2      5
     *             4
     * =========================
     *  Expected result
     *  BFS traversing
     *  1
     *  3
     *  2
     *  5
     *  4
     */
    @Test
    public void whenUseBFSTraversingThenPrintTheResult() {
        Tree<Integer> tree = new Tree<>();

        tree.put(1);
        tree.put(3);
        tree.put(5);
        tree.put(4);
        tree.put(2);

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(tree);
        System.out.println("BFS traversing");
        List<Integer> actual = bfs.traverse();
        List<Integer> expected = Arrays.asList(1, 3, 2, 5, 4);
        actual.forEach(System.out::println);

        assertThat(actual, is(expected));

    }

    @Test
    public void whenGetFromEmptyTreeThenEmptyOptional() {
        Tree<Integer> tree = new Tree<>();

        Optional<Integer> actual = tree.get(1);
        Optional<Integer> expected = Optional.empty();

        assertThat(actual, is(expected));
    }

    @Test
    public void when_addingDuplicate_then_CheckNoEffectOnTree() {
        Tree<Integer> tree = new Tree<>();
        tree.put(1);
        tree.put(3);
        tree.put(5);
        tree.put(4);
        tree.put(2);


        Optional<Integer> actual = tree.get(5);
        Optional<Integer> expected = Optional.of(5);
        allDfsTraversal(tree);

        tree.put(5);
        Optional<Integer> actual2 = tree.get(5);
        allDfsTraversal(tree);

        assertThat(actual, is(expected));
        assertThat(actual, is(actual2));
    }

    private void allDfsTraversal(Tree<Integer> tree) {
        DepthFirstSearch dfs = new DepthFirstSearch(tree);
        System.out.println("Pre order DFS traversing");
        dfs.preOrder();
        System.out.println("In order DFS traversing");
        dfs.inOrder();
        System.out.println("Post order DFS traversing");
        dfs.postOrder();
    }



}
