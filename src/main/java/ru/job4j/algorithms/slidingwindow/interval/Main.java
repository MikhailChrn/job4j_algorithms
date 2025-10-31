package ru.job4j.algorithms.slidingwindow.interval;

import java.util.*;

public class Main {

    /**
     * Этот метод должен находить и возвращать границы нового интервала,
     * который перекрывает максимальное количество других интервалов.
     */
    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[]{-1, -1};
        }

        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        Queue<Interval> activeIntervals = new PriorityQueue<>(
                Comparator.comparingInt(interval -> interval.end));
        int maxOverlap = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int currentStart;

        for (Interval interval : intervals) {
            currentStart = interval.start;

            while (!activeIntervals.isEmpty() && activeIntervals.peek().end <= currentStart) {
                activeIntervals.poll();
            }

            activeIntervals.offer(interval);

            if (activeIntervals.size() > maxOverlap) {
                maxOverlap = activeIntervals.size();
                maxStart = currentStart;
                maxEnd = activeIntervals.peek().end;
            }
        }

        return new int[]{
                maxStart, maxEnd
        };
    }

    public static void main(String[] args) {
        List intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}
