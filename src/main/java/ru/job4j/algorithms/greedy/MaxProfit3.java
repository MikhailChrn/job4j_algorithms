package ru.job4j.algorithms.greedy;

public class MaxProfit3 {

    /**
     * Greedy solution
     */
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] > minPrice + fee) {
                profit += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }

        return profit;
    }

    /**
     * Dynamic solution
     */
    public int maxProfit2(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    public int maxProfitMikhail(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int sumProf = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] > minValue + fee) {
                sumProf += prices[i] - minValue - fee;
                minValue = prices[i] - fee;
            }
        }

        return sumProf;
    }
}

