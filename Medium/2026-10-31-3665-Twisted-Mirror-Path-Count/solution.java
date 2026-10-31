class Solution {
    private static final int MOD = 1000000007;
    
    public int uniquePathsWithTwists(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (grid[i][j] == 1) continue;

                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    if (grid[i - 1][j] == 1) {
                        int newJ = j + 1;
                        if (newJ < n) {
                            dp[i][newJ] = (dp[i][newJ] + dp[i - 1][j]) % MOD;
                        }
                    }
                }
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    if (grid[i][j - 1] == 1) {
                        int newI = i + 1;
                        if (newI < m) {
                            dp[newI][j] = (dp[newI][j] + dp[i][j - 1]) % MOD;
                        }
                    }
                }
            }
        }
        
        return (int) dp[m - 1][n - 1];
    }
}