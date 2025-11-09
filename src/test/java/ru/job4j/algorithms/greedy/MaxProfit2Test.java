package ru.job4j.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfit2Test {
    @Test
    void case1() {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int expRes = 7;

        assertEquals(expRes, maxProfit2.maxProfit(prices));
    }

    @Test
    void case2() {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = new int[]{1, 2, 3, 4, 5};
        int expRes = 4;

        assertEquals(expRes, maxProfit2.maxProfit(prices));
    }

    @Test
    void case3() {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int expRes = 0;

        assertEquals(expRes, maxProfit2.maxProfit(prices));
    }
}