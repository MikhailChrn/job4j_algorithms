package ru.job4j.algorithms.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSlidingWindowTest {

    @Test
    public void case1() {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] expRes = new int[]{3, 3, 5, 5, 6, 7};
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }

    @Test
    public void case2() {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();

        int[] nums = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;

        int[] expRes = new int[]{10, 10, 9, 2};
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }

    @Test
    public void case3() {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();

        int[] nums = new int[]{9, 8, 7};
        int k = 2;

        int[] expRes = new int[]{9, 8};
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }
}