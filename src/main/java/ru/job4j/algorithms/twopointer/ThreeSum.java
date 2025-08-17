package ru.job4j.algorithms.twopointer;

import java.util.*;

/**
 * nums[i] + nums[j] + nums[k] == 0
 *
 * Подсказка 1
 * Итак, нам, по сути, нужно найти три числа x, y и z, которые в сумме дают заданное значение.
 * Если мы исправим одно из чисел, скажем, x, мы получим задачу с двумя суммами!
 *
 * Подсказка 2
 * В задаче с двумя суммами, если мы фиксируем одно из чисел, скажем, x,
 * нам нужно просканировать весь массив, чтобы найти следующее число y, которое равно value - x,
 * где value - входной параметр. Можем ли мы как-то изменить наш массив, чтобы ускорить поиск?
 *
 * Подсказка 3
 * Второй ход мыслей для two-sum заключается в том, что,
 * не изменяя массив, мы можем как-то использовать дополнительное пространство?
 * Например, возможно, хэш-карта для ускорения поиска?
 */

public class ThreeSum {

    public static List<List<Integer>> threeSumMikhailFirstTime(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length < 3) {
            return List.of(List.of());
        }
        List<Integer> list = new ArrayList<>();
        int diff, dif, j;
        for (int i = 0; i < nums.length - 2; i++) {
            list.clear();
            dif = 0 - nums[i];
            for (j = i + 1; j < nums.length; j++) {
                diff = dif - nums[j];
                if (list.contains(diff)) {
                    List<Integer> subList = new ArrayList<>(Arrays.asList(nums[i], diff, nums[j]));
                    Collections.sort(subList);
                    res.add(subList);
                    continue;
                }
                list.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int l, r, sum, target;

        for (int i = 0; i < nums.length - 2; i++) {
            // Пропускаем дубликаты (обратить внимание. это хитрая строчка);
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Используем два указателя
            target = -nums[i];
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    // Пропускаем дубликаты
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
