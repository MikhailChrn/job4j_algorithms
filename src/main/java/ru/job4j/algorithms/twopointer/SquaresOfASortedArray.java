package ru.job4j.algorithms.twopointer;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */

public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int resIdx = right;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[resIdx] = nums[left] * nums[left];
                left++;
            } else {
                res[resIdx] = nums[right] * nums[right];
                right--;
            }
            resIdx--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-4, -2, 0, 2, 3, 5};
        int[] resultArray = sortedSquares(sortedArray);
        System.out.println(Arrays.toString(resultArray));
    }
}
