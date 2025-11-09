package ru.job4j.algorithms.greedy;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int maxProf = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProf = Math.max(maxProf, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }

        return maxProf;
    }
}
