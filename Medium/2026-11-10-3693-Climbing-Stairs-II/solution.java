class Solution {
    public int minCost(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    int cost = costs[i - j] + j * j;
                    dp[i] = Math.min(dp[i], dp[i - j] + cost);
                }
            }
        }
        
        return dp[n];
    }
}