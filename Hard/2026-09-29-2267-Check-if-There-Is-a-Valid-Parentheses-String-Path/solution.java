class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] dp = new boolean[m][n][m + n + 1];
        dp[0][0][1] = grid[0][0] == '(';

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= m + n; k++) {
                    if (dp[i][j][k]) {
                        if (i + 1 < m) {
                            int nextK = k + (grid[i + 1][j] == '(' ? 1 : -1);
                            if (nextK >= 0) {
                                dp[i + 1][j][nextK] = true;
                            }
                        }
                        if (j + 1 < n) {
                            int nextK = k + (grid[i][j + 1] == '(' ? 1 : -1);
                            if (nextK >= 0) {
                                dp[i][j + 1][nextK] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int k = 0; k <= m + n; k++) {
            if (dp[m - 1][n - 1][k] && k == 0) {
                return true;
            }
        }
        return false;
    }
}