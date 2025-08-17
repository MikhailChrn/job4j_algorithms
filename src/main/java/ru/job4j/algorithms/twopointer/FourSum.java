package ru.job4j.algorithms.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.Пропускаем дубликаты для 'a' (получено экспериментальным путём);
 * 2.Пропускаем дубликаты для 'b' (получено экспериментальным путём);
 * 3.Решаем как '3sum';
 */

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int b, c, d;
        long sumAB, sumCD;
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (b = a + 1; b < nums.length - 2; b++) {
                if (b != a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                sumAB = nums[a] + nums[b];
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    sumCD = nums[c] + nums[d];
                    if (sumCD == target - sumAB) {
                        res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c > d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        c++;
                        d--;
                    } else if (sumCD < target - sumAB) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        } return res;
    }
}
