package ru.job4j.algorithms.twopointer;

import java.util.Arrays;

public class SmallestRangeFinder {
    /**
     * У вас есть отсортированный массив целых чисел и число k.
     * Ваша задача - найти наименьший диапазон в массиве,
     * который содержит как минимум k различных элементов.
     */

    public static int[] findSmallestRange(int[] nums, int k) {
        if (nums.length < k
                || nums[nums.length - 1] - nums[0] + 1 < k) {

            return null;
        }

        int right;

        for (int range = k; range < nums.length; range++) {
            for (right = range - 1; right < nums.length; right++) {
                if (nums[right] - nums[right - range + 1] >= k) {
                    return new int[]{right - range + 1, right};
                }
            }
        }

        return new int[]{nums.length - 1, 0};

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
