import java.util.*;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int[][] arr : dp) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        dp[0][0][0] = 0;

        for (int cost = 0; cost <= k; cost++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j][cost] == -1) continue;
                    int score = dp[i][j][cost];
                    if (i + 1 < m) {
                        int newCost = cost + (grid[i + 1][j] == 1 ? 1 : (grid[i + 1][j] == 2 ? 1 : 0));
                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(dp[i + 1][j][newCost], score + grid[i + 1][j]);
                        }
                    }
                    if (j + 1 < n) {
                        int newCost = cost + (grid[i][j + 1] == 1 ? 1 : (grid[i][j + 1] == 2 ? 1 : 0));
                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(dp[i][j + 1][newCost], score + grid[i][j + 1]);
                        }
                    }
                }
            }
        }

        int maxScore = -1;
        for (int cost = 0; cost <= k; cost++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][cost]);
        }
        return maxScore;
    }
}