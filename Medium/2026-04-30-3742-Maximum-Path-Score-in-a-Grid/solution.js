class Solution {
    maxScore(grid, k) {
        const m = grid.length;
        const n = grid[0].length;
        const dp = Array.from({ length: m }, () => Array.from({ length: n }, () => Array(k + 1).fill(-1)));
        dp[0][0][0] = 0;

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                for (let cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] === -1) continue;
                    const score = dp[i][j][cost];

                    // Move right
                    if (j + 1 < n) {
                        const nextCost = cost + (grid[i][j + 1] === 1 ? 1 : grid[i][j + 1] === 2 ? 1 : 0);
                        const nextScore = score + (grid[i][j + 1] === 1 ? 1 : grid[i][j + 1] === 2 ? 2 : 0);
                        if (nextCost <= k) {
                            dp[i][j + 1][nextCost] = Math.max(dp[i][j + 1][nextCost], nextScore);
                        }
                    }

                    // Move down
                    if (i + 1 < m) {
                        const nextCost = cost + (grid[i + 1][j] === 1 ? 1 : grid[i + 1][j] === 2 ? 1 : 0);
                        const nextScore = score + (grid[i + 1][j] === 1 ? 1 : grid[i + 1][j] === 2 ? 2 : 0);
                        if (nextCost <= k) {
                            dp[i + 1][j][nextCost] = Math.max(dp[i + 1][j][nextCost], nextScore);
                        }
                    }
                }
            }
        }

        let maxScore = -1;
        for (let cost = 0; cost <= k; cost++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][cost]);
        }

        return maxScore;
    }
}