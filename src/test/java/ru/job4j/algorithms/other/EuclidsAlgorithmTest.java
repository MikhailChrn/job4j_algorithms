package ru.job4j.algorithms.other;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EuclidsAlgorithmTest {

    @Test
    void case1() {
        int a = 111;
        int b = 432;
        int expected = 3;

        assertThat(EuclidsAlgorithm.greatestCommonDivisor(a, b))
                .isEqualTo(expected);
    }

    @Test
    void case2() {
        int a = 12;
        int b = 16;
        int expected = 4;

        assertThat(EuclidsAlgorithm.greatestCommonDivisor(a, b))
                .isEqualTo(expected);
    }

    @Test
    void case3() {
        int a = 48;
        int b = 64;
        int expected = 16;

        assertThat(EuclidsAlgorithm.greatestCommonDivisor(a, b))
                .isEqualTo(expected);
    }

    @Test
    void case4() {
        int a = 1;
        int b = 2;
        int expected = 1;

        assertThat(EuclidsAlgorithm.greatestCommonDivisor(a, b))
                .isEqualTo(expected);
    }
}