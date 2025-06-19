package ru.job4j.algorithms.hashstructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 19.06.2025
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int diff;

        for (int p = 0; p < nums.length; p++) {
            diff = target - nums[p];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), p};
            } else {
                map.put(nums[p], p);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("case #1");
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

        System.out.println("case #2");
        nums = new int[] {3,2,4};
        target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

        System.out.println("case #3");
        nums = new int[] {3,3};
        target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }
}
