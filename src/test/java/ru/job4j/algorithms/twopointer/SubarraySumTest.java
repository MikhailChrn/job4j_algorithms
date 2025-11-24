package ru.job4j.algorithms.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumTest {
    @Test
    void case1() {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        int expRes = 2;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case2() {
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        int expRes = 2;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case3() {
        int[] nums = new int[]{3, 4, 7, -2, 2, 1, 4, 2};
        int k = 7;
        int expRes = 6;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case4() {
        int[] nums = new int[]{2, 3, 6, 5, 4, 1, 10};
        int k = 5;
        int expRes = 3;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case5() {
        int[] nums = new int[]{-1, -1, 1};
        int k = 0;
        int expRes = 1;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case6() {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;
        int expRes = 3;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }

    @Test
    void case7() {
        int[] nums = new int[]{-1};
        int k = 0;
        int expRes = 0;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }



    /*@Test
    void case8() {
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1};
        int k = 0;
        int expRes = 0;

        SubarraySum subarraySum = new SubarraySum();

        assertEquals(expRes, subarraySum.subarraySum(nums, k));
    }*/
}