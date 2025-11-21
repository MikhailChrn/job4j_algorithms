package ru.job4j.algorithms.tree.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AvlTreeRemoveTest {

    @Test
    void whenRemoveLeafThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 7}) {
            tree.insert(element);
        }

        assertThat(tree.remove(1)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(6)
                .containsExactly(2, 3, 4, 5, 6, 7);
        assertThat(tree.contains(1)).isFalse();
    }

    @Test
    void whenRemoveNodeWithOneChildThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 5, 7}) {
            tree.insert(element);
        }

        assertThat(tree.remove(2)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(5)
                .containsExactly(1, 4, 5, 6, 7);
    }

    @Test
    void whenRemoveNodeWithTwoChildrenThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 7}) {
            tree.insert(element);
        }

        assertThat(tree.remove(4)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(6)
                .containsExactly(1, 2, 3, 5, 6, 7);
        assertThat(tree.contains(4)).isFalse();
    }

    @Test
    void whenRemoveRootWithTwoChildrenComplexThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{50, 30, 70, 20, 40, 60, 80, 55, 65}) {
            tree.insert(element);
        }

        assertThat(tree.remove(50)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(8)
                .containsExactly(20, 30, 40, 55, 60, 65, 70, 80);
    }

    @Test
    void whenRemoveNonExistentElementThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 7}) {
            tree.insert(element);
        }

        assertThat(tree.remove(99)).isFalse();
        assertThat(tree.inSymmetricalOrder()).hasSize(7);
    }

    @Test
    void whenRemoveFromEmptyTreeThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        assertThat(tree.remove(5)).isFalse();
    }

    @Test
    void whenRemoveNullThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(5);
        assertThat(tree.remove(null)).isFalse();
    }

    @Test
    void whenRemoveRootWithOneChildThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(5);
        tree.insert(3);

        assertThat(tree.remove(5)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(1)
                .containsExactly(3);

        assertThat(tree.contains(3)).isTrue();
        assertThat(tree.minimum()).isEqualTo(3);
        assertThat(tree.maximum()).isEqualTo(3);
    }

    @Test
    void whenRemoveRootAloneThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(5);

        assertThat(tree.remove(5)).isTrue();
        assertThat(tree.inSymmetricalOrder()).isEmpty();
        assertThat(tree.contains(5)).isFalse();

        assertThat(tree.minimum()).isNull();
        assertThat(tree.maximum()).isNull();
    }

    @Test
    void whenRemoveAndAddAgainThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);

        assertThat(tree.remove(5)).isTrue();
        assertThat(tree.insert(5)).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(3)
                .containsExactly(3, 5, 7);
    }

    @Test
    void whenMultipleRemovalsThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{50, 30, 70, 20, 40, 60, 80}) {
            tree.insert(element);
        }

        assertThat(tree.remove(20)).isTrue();
        assertThat(tree.remove(30)).isTrue();
        assertThat(tree.remove(50)).isTrue();

        assertThat(tree.inSymmetricalOrder()).hasSize(4)
                .containsExactly(40, 60, 70, 80);
    }

}