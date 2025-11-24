package ru.job4j.algorithms.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Подсказка 3
 * А что, если хранить суммарные частоты в хэш-таблице? Будет ли это полезно?
 * Подсказка 4
 * sum(i,j)=sum(0,j)-sum(0,i), где sum(i,j) представляет собой сумму всех элементов
 * с индексами от i до j-1. Можно ли использовать это свойство для оптимизации?
 */

public class SubarraySum {
    public int subarraySumMikh(int[] nums, int k) {
        int count = 0;
        int left = -1;
        int sumLeft = 0;
        int right = 0;
        int sumRight = nums[0];
        int currSum;

        while (left != nums.length - 1) {
            currSum = sumRight - sumLeft;

            if (currSum == k) {
                count++;
                if (left != nums.length - 1) {
                    left++;
                    sumLeft += nums[left];
                    right = left;
                    sumRight = sumLeft;
                }

            } else if (currSum < k && right != nums.length - 1) {
                right++;
                sumRight += nums[right];

            } else {
                if (left != nums.length - 1) {
                    left++;
                    sumLeft += nums[left];
                    right = left;
                    sumRight = sumLeft;
                }
            }
        }

        return count;
    }

    /**
     * map - это дневник, где мы записываем:
     * "На какой высоте я уже был и сколько раз"
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // ← ЗАПОМНИ ЭТУ СТРОЧКУ!
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;                    // текущая высота
            if (map.containsKey(sum - k)) { // была ли нужная высота раньше?
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // записываем текущую высоту
        }

        return count;
    }
}
