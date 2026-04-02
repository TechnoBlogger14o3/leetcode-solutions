class Solution {
    public int maxCoins(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        
        dp[0][0][0] = coins[0][0] >= 0 ? coins[0][0] : 0;
        dp[0][0][1] = coins[0][0] < 0 ? -coins[0][0] : 0;
        dp[0][0][2] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    int currentCoins = dp[i][j][k];
                    if (i + 1 < m) {
                        int nextCoins = currentCoins + coins[i + 1][j];
                        if (coins[i + 1][j] < 0) {
                            if (k < 2) {
                                dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], currentCoins);
                            }
                        } else {
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], nextCoins);
                        }
                    }
                    if (j + 1 < n) {
                        int nextCoins = currentCoins + coins[i][j + 1];
                        if (coins[i][j + 1] < 0) {
                            if (k < 2) {
                                dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], currentCoins);
                            }
                        } else {
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], nextCoins);
                        }
                    }
                }
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            maxProfit = Math.max(maxProfit, dp[m - 1][n - 1][k]);
        }
        
        return maxProfit;
    }
}