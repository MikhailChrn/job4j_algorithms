package ru.job4j.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Задан массив из интервалов.
 * Необходимо объединить перекрывающиеся интервалы.
 * <p>
 * Учитывая массив интервалов, где intervals[i] = [starti, endi],
 * объединяем все перекрывающиеся интервалы и возвращаем
 * массив непересекающихся интервалов,
 * которые охватывают все интервалы во входных данных.
 */

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (res.getLast()[1] >= intervals[i][0]) {
                res.getLast()[0] = Math.min(res.getLast()[0], intervals[i][0]);
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.stream().toArray(int[][]::new);
    }
}
