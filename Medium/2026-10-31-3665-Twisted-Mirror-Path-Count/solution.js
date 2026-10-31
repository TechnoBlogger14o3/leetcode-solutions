class Solution {
    countPaths(grid) {
        const MOD = 1e9 + 7;
        const m = grid.length;
        const n = grid[0].length;
        const dp = Array.from({ length: m }, () => Array(n).fill(0));
        
        dp[0][0] = 1;

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (grid[i][j] === 1) continue;

                if (i + 1 < m) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                    if (grid[i + 1][j] === 1) {
                        if (j + 1 < n) {
                            dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                        }
                    }
                }

                if (j + 1 < n) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                    if (grid[i][j + 1] === 1) {
                        if (i + 1 < m) {
                            dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}