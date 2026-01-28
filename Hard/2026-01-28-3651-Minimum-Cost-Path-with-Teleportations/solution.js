class Solution {
    minCost(grid, k) {
        const m = grid.length, n = grid[0].length;
        const INF = Infinity;
        const dp = Array.from({ length: m }, () => Array.from({ length: n }, () => Array(k + 1).fill(INF)));
        dp[0][0][k] = 0;

        const directions = [[1, 0], [0, 1]];

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                for (let t = 0; t <= k; t++) {
                    if (dp[i][j][t] === INF) continue;

                    for (const [dx, dy] of directions) {
                        const ni = i + dx, nj = j + dy;
                        if (ni < m && nj < n) {
                            dp[ni][nj][t] = Math.min(dp[ni][nj][t], dp[i][j][t] + grid[ni][nj]);
                        }
                    }

                    if (t > 0) {
                        const teleportCost = grid[i][j];
                        for (let x = 0; x < m; x++) {
                            for (let y = 0; y < n; y++) {
                                if (grid[x][y] <= teleportCost) {
                                    dp[x][y][t - 1] = Math.min(dp[x][y][t - 1], dp[i][j][t]);
                                }
                            }
                        }
                    }
                }
            }
        }

        let minCost = INF;
        for (let t = 0; t <= k; t++) {
            minCost = Math.min(minCost, dp[m - 1][n - 1][t]);
        }

        return minCost;
    }
}