package ru.job4j.algorithms.twopointer;

public class Compress2Point {
    public static int[] compress(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0) {
                        array[i] = array[j];
                        array[j] = 0;
                        break;
                    }
                }
            }
        }
        return array;
    }

    public static int[] compress2Point(int[] array) {
        int left = 0;
        int right = 0;
        while (right < array.length) {
            if (array[left] == 0 && array[right] != 0) {
                array[left] = array[right];
                array[right] = 0;
            }
            if (array[left] != 0) {
                left++;
            }
            right++;
        }
        return array;
    }
}
