package ru.job4j.algorithms.slidingwindow;

import java.util.*;

/**
 * Заданы время посещения клиентов банка в виде
 * списка интервалов [[begin, end], ...],
 * где begin - время прибытия клиента,
 * end - время ухода клиента.
 * Необходимо вычислить время максимальной загруженности банка,
 * то есть время, когда в банке находилось наибольшее количество клиентов.
 */

public class BankMaxLoadTime {

    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        if (visitTimes.isEmpty()) {
            return new int[]{-1, -1};
        }

        visitTimes.sort(Comparator.comparingInt(array -> array[0]));

        Queue<int[]> activeVisits = new PriorityQueue<>(
                Comparator.comparingInt(array -> array[1]));

        int maxLoadStartTime = 0;
        int maxLoadEndTime = 0;
        int maxLoadOverlap = 0;
        int currentStart;

        for (int[] visit : visitTimes) {
            currentStart = visit[0];

            while (!activeVisits.isEmpty() && activeVisits.peek()[1] <= currentStart) {
                activeVisits.poll();
            }

            activeVisits.offer(visit);

            if (activeVisits.size() > maxLoadOverlap) {
                maxLoadOverlap = activeVisits.size();
                maxLoadStartTime = currentStart;
                maxLoadEndTime = activeVisits.peek()[1];
            }
        }

        return new int[]{maxLoadStartTime, maxLoadEndTime};
    }

    static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}
