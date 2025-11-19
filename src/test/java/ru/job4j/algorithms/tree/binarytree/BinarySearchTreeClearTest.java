package ru.job4j.algorithms.tree.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeClearTest {

    @Test
    void whenClearThenTreeStructureReset() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Arrays.stream(new int[]{4, 7, 6, 5, 3, 2, 1})
                .forEach(tree::put);

        assertEquals(tree.inSymmetricalOrder().size(), 7);

        tree.clear();

        assertThat(tree.inSymmetricalOrder()).isEmpty();
        assertThat(tree.contains(5)).isFalse();

        tree.put(10);
        assertThat(tree.inSymmetricalOrder()).containsExactly(10);
    }
}