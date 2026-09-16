class Solution {
    private static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1; // Base case: 1 way to choose 0 segments
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 2 * i; j <= n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 2]) % MOD;
            }
        }

        return (int) dp[k][n];
    }
}