class Solution:
    def minPathXor(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[float('inf')] * n for _ in range(m)]
        dp[0][0] = grid[0][0]

        for i in range(m):
            for j in range(n):
                if i > 0:
                    dp[i][j] = min(dp[i][j], dp[i-1][j] ^ grid[i][j])
                if j > 0:
                    dp[i][j] = min(dp[i][j], dp[i][j-1] ^ grid[i][j])

        return dp[m-1][n-1]