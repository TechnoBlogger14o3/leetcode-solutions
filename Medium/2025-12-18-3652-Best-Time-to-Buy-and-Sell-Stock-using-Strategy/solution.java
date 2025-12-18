class Solution {
    public long maximumProfit(int[] prices, int[] strategy, int k) {
        long originalProfit = calculateProfit(prices, strategy);
        long maxProfit = originalProfit;

        for (int i = 0; i <= strategy.length - k; i++) {
            long modifiedProfit = calculateModifiedProfit(prices, strategy, i, k);
            maxProfit = Math.max(maxProfit, modifiedProfit);
        }

        return maxProfit;
    }

    private long calculateProfit(int[] prices, int[] strategy) {
        long profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit += (long) strategy[i] * prices[i];
        }
        return profit;
    }

    private long calculateModifiedProfit(int[] prices, int[] strategy, int start, int k) {
        long profit = 0;
        int halfK = k / 2;

        for (int i = 0; i < start; i++) {
            profit += (long) strategy[i] * prices[i];
        }

        for (int i = start; i < start + halfK; i++) {
            profit += 0 * prices[i]; // Holding
        }

        for (int i = start + halfK; i < start + k; i++) {
            profit += 1 * prices[i]; // Selling
        }

        for (int i = start + k; i < prices.length; i++) {
            profit += (long) strategy[i] * prices[i];
        }

        return profit;
    }
}