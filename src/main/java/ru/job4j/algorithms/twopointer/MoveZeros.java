package ru.job4j.algorithms.twopointer;

/**
 * Отсчёт обоих 'point' ведём от 'нуля', это принципиально.
 * Получаем:
 * r - прибавляется на каждое повторение;
 * l - реализует отставание при встрече нулей;
 */
public class MoveZeros {

    public static void moveZeros(int[] nums) {
        int l = 0;
        int r = 0;
        int tmp;

        while (r < nums.length) {
            if (nums[r] != 0) {
                tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;

                l++;
            }

            r++;
        }
    }
}
