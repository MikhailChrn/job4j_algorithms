package ru.job4j.algorithms.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianSlidingWindowTest {

    @Test
    public void case1() {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        double[] expRes = new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
        double[] result = medianSlidingWindow.medianSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }

    @Test
    public void case2() {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 4;

        double[] expRes = new double[]{0.0, 1.0, 1.0, 4.0, 5.5};
        double[] result = medianSlidingWindow.medianSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }

    @Test
    public void case3() {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();

        int[] nums = new int[]{2147483647, 2147483647};
        int k = 2;

        double[] expRes = new double[]{2147483647.0};
        double[] result = medianSlidingWindow.medianSlidingWindow(nums, k);

        assertArrayEquals(expRes, result);
    }
}