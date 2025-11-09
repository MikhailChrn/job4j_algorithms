package ru.job4j.algorithms.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfit3Test {
    @Test
    void case1() {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int expRes = 8;

        assertEquals(expRes, maxProfit3.maxProfitMikhail(prices, fee));
    }

    @Test
    void case2() {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        int expRes = 6;

        assertEquals(expRes, maxProfit3.maxProfitMikhail(prices, fee));
    }

}