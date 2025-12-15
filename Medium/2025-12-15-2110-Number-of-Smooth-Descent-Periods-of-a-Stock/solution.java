class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int n = prices.length;
        int currentPeriod = 1;

        for (int i = 1; i < n; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                currentPeriod++;
            } else {
                currentPeriod = 1;
            }
            count += currentPeriod;
        }
        
        return count + n; // Add n for the single-day periods
    }
}