package ru.job4j.algorithms.greedy;

public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int sumProf = 0;
        int maxProf = 0;
        int prof = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            prof = prices[i] - minValue;
            maxProf = Math.max(maxProf, prof);

            if (prof <= maxProf) {
                sumProf += maxProf;
                maxProf = 0;
                minValue = prices[i];
            } else {
                sumProf = maxProf;
            }
        }

        return sumProf;
    }
}
