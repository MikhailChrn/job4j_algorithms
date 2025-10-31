package ru.job4j.algorithms.slidingwindow.interval;

/**
 *  Класс Interval: Представляет интервал с началом (`start`) и концом (`end`).
 */

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", start, end);
    }
}
