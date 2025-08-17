package ru.job4j.algorithms.other;

/**
 * Алгоритм "Евклида"
 * нахождение 'Наибольшего Общего Делителя'
 *
 * 17.08.2025 г.
 */

public class EuclidsAlgorithm {
    public static int greatestCommonDivisor(int a, int b) {
        int tmp;

        if (b > a) {
            tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}
