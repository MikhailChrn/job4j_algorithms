package ru.job4j.algorithms.tree.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AvlTreeRotationTest {

    @Test
    void whenLLCaseThenRightRotationIsApplied() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertThat(tree.inPreOrder())
                .containsExactly(2, 1, 3);
    }

    @Test
    void whenRRCaseThenLeftRotationIsApplied() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertThat(tree.inPreOrder())
                .containsExactly(2, 1, 3);
    }

    @Test
    void whenLRCaseThenLeftRightRotationIsApplied() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);

        assertThat(tree.inPreOrder())
                .containsExactly(2, 1, 3);
    }

    @Test
    void whenRLCaseThenRightLeftRotationIsApplied() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        assertThat(tree.inPreOrder())
                .containsExactly(2, 1, 3);
    }
}