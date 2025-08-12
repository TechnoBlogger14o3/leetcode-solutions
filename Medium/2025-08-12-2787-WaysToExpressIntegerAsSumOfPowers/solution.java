class Solution {
    private static final int MOD = 1000000007;
    
    public int numberOfWays(int n, int x) {
        // dp[i][j] represents the number of ways to express i using powers up to j^x
        int[][] dp = new int[n + 1][n + 1];
        
        // Base case: there's 1 way to express 0 (empty sum)
        dp[0][0] = 1;
        
        // For each possible sum
        for (int sum = 0; sum <= n; sum++) {
            // For each possible power base
            for (int base = 1; base <= n; base++) {
                int power = (int) Math.pow(base, x);
                
                // If power exceeds the sum, we can't use this base
                if (power > sum) {
                    dp[sum][base] = dp[sum][base - 1];
                } else {
                    // We can either use this power or not
                    // If we use it: dp[sum - power][base - 1]
                    // If we don't use it: dp[sum][base - 1]
                    dp[sum][base] = (dp[sum][base - 1] + dp[sum - power][base - 1]) % MOD;
                }
            }
        }
        
        return dp[n][n];
    }
}
