package ru.job4j.algorithms.slidingwindow;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 * Hint 1
 * How about using a data structure such as deque (double-ended queue)?
 * Hint 2
 * The queue size need not be the same as the window’s size.
 * Hint 3
 * Remove redundant elements and the queue should store only elements that need to be considered.
 */

public class MaxSlidingWindow {
    public int[] maxSlidingWindowFirstTime(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException("Размер окна должен быть меньше или равен длине массива");
        }

        int[] res = new int[nums.length - k + 1];
        int max = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }
        res[0] = Collections.max(deque);

        for (int i = 1; i <= nums.length - k; i++) {
            deque.pollFirst();
            deque.offerLast(nums[i + k - 1]);
            res[i] = Collections.max(deque);
        }

        return res;
    }

    public int[] maxSlidingWindowSecondTime(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException("Размер окна должен быть меньше или равен длине массива");
        }

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            deque.add(nums[i]);
        }
        res[0] = Collections.max(deque);

        for (int i = 1; i <= nums.length - k; i++) {
            if (deque.peekFirst() == res[i - 1]) {
                deque.pollFirst();
                deque.offerLast(nums[i + k - 1]);
                res[i] = Collections.max(deque);
            } else {
                deque.pollFirst();
                if (nums[i + k - 1] > res[i - 1]) {
                    deque.offerLast(nums[i + k - 1]);
                    res[i] = nums[i + k - 1];
                    continue;
                }

                deque.offerLast(nums[i + k - 1]);
                res[i] = Collections.max(deque);
            }
        }

        return res;
    }

    /**
     * В очереде храним индексы
     * 1й while - Удаляем индексы, которые вышли за границы окна
     * 2й while - Удаляем из deque все элементы, которые меньше текущего
     * Это гарантирует, что первый элемент всегда будет максимальным
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException("Размер окна должен быть меньше или равен длине массива");
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
