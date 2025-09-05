package ru.job4j.algorithms.slidingwindow;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MinimumSizeSubarraySumTest {
    @Test
    void case1() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        int exp = 2;
        int res = MinimumSizeSubarraySum.minSubArrayLen(target, nums);

        Assert.assertEquals(res, exp);
    }

    @Test
    void case2() {
        int[] nums = new int[]{1, 4, 4};
        int target = 4;
        int exp = 1;
        int res = MinimumSizeSubarraySum.minSubArrayLen(target, nums);

        Assert.assertEquals(res, exp);
    }

    @Test
    void case3() {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        int exp = 0;
        int res = MinimumSizeSubarraySum.minSubArrayLen(target, nums);

        Assert.assertEquals(res, exp);
    }

    @Test
    void case4() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 11;
        int exp = 3;
        int res = MinimumSizeSubarraySum.minSubArrayLen(target, nums);

        Assert.assertEquals(res, exp);
    }

    @Test
    void case5() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 15;
        int exp = 5;
        int res = MinimumSizeSubarraySum.minSubArrayLen(target, nums);

        Assert.assertEquals(res, exp);
    }

}