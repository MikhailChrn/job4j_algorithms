package ru.job4j.algorithms.slidingwindow;

import java.util.Arrays;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException("Размер окна должен быть меньше или равен длине массива");
        }

        double[] result = new double[nums.length - k + 1];
        int[] win = new int[k];

        for (int i = 0; i <= nums.length - k; i++) {
            win = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(win);

            if (k % 2 == 1) {
                result[i] = win[k / 2];
            } else {
                result[i] = (double) ((long) win[k / 2 - 1] + (long) win[k / 2]) / 2;
            }
        }

        return result;
    }
}
