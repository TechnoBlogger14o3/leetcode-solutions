class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        int[][] dp = new int[n][n];
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    int leftSum = prefixSum[k + 1] - prefixSum[i];
                    int rightSum = prefixSum[j + 1] - prefixSum[k + 1];
                    if (leftSum < rightSum) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + leftSum);
                    } else if (leftSum > rightSum) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + rightSum);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k] + leftSum, dp[k + 1][j] + rightSum));
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}