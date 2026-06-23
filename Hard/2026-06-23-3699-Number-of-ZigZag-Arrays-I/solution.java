class Solution {
    public int zigzagArrays(int n, int l, int r) {
        final int MOD = 1000000007;
        int range = r - l + 1;
        
        if (range < 2) return 0;

        long[][] dp = new long[n][2];
        dp[0][0] = range; // Starting with a value less than the next
        dp[0][1] = range; // Starting with a value greater than the next

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] * (range - 1)) % MOD; // Previous was greater
            dp[i][1] = (dp[i - 1][0] * (range - 1)) % MOD; // Previous was less
            if (i > 1) {
                dp[i][0] = (dp[i][0] + dp[i - 2][0] * (range - 2)) % MOD; // Previous was less, less
                dp[i][1] = (dp[i][1] + dp[i - 2][1] * (range - 2)) % MOD; // Previous was greater, greater
            }
        }

        return (int)((dp[n - 1][0] + dp[n - 1][1]) % MOD);
    }
}