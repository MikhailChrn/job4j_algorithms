package ru.job4j.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {
    @Test
    void case1() {
        MaxProfit maxProfit = new MaxProfit();

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int expRes = 5;

        assertEquals(expRes, maxProfit.maxProfit(prices));
    }

    @Test
    void case2() {
        MaxProfit maxProfit = new MaxProfit();

        int[] prices = new int[]{7, 6, 4, 3, 1};
        int expRes = 0;

        assertEquals(expRes, maxProfit.maxProfit(prices));
    }

    @Test
    void case3() {
        MaxProfit maxProfit = new MaxProfit();

        int[] prices = new int[]{2, 4, 1};
        int expRes = 2;

        assertEquals(expRes, maxProfit.maxProfit(prices));
    }

    @Test
    void case4() {
        MaxProfit maxProfit = new MaxProfit();

        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int expRes = 4;

        assertEquals(expRes, maxProfit.maxProfit(prices));

    }

}