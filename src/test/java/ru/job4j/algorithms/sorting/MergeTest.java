package ru.job4j.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {
    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void case1() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, -6};
        assertThat(Merge.mergesort(array)).containsExactly(-6, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void case2() {
        int[] array = {-9, 8, -7, 6, -5, 4, -3, 2, -6, -10, 10, 0};
        assertThat(Merge.mergesort(array))
                .containsExactly(-10, -9, -7, -6, -5, -3, 0, 2, 4, 6, 8, 10);

    }

    @Test
    void case3() {
        int[] array = {0, -2, 3};
        assertThat(Merge.mergesort(array))
                .containsExactly(-2, 0, 3);

    }
}