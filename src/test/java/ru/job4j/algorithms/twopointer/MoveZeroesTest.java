package ru.job4j.algorithms.twopointer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.job4j.algorithms.twopointer.MoveZeros.moveZeros;

class MoveZerosTest {

    @Test
    void case1() {
        int[] case1 = new int[]{0, 1, 0, 3, 12};

        MoveZeros.moveZeros(case1);

        Arrays.stream(case1).forEach(System.out::println);
    }

    @Test
    void case2() {
        int[] case2 = new int[]{0, 0, 0};

        MoveZeros.moveZeros(case2);

        Arrays.stream(case2).forEach(System.out::println);
    }

    @Test
    void case3() {
        int[] case3 = new int[]{1, 2, 3, 1};

        MoveZeros.moveZeros(case3);

        Arrays.stream(case3).forEach(System.out::println);
    }

}