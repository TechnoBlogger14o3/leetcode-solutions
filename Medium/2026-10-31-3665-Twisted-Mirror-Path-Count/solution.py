class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1
        
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                if grid[i][j] == 0:
                    if i > 0:
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD
                    if j > 0:
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD
                else:
                    if i > 0 and j < n - 1:
                        dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % MOD
                    if j > 0 and i < m - 1:
                        dp[i + 1][j] = (dp[i + 1][j] + dp[i][j - 1]) % MOD
        
        return dp[m - 1][n - 1]