class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])
        
        dp = [[(0, 0) for _ in range(n)] for _ in range(m)]
        dp[0][0] = (grid[0], grid[0])
        
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                max_product = float('-inf')
                min_product = float('inf')
                
                if i > 0:
                    max_product = max(max_product, dp[i-1][j][0] * grid[i][j])
                    min_product = min(min_product, dp[i-1][j][1] * grid[i][j])
                if j > 0:
                    max_product = max(max_product, dp[i][j-1][0] * grid[i][j])
                    min_product = min(min_product, dp[i][j-1][1] * grid[i][j])
                
                dp[i][j] = (max_product, min_product)
        
        max_product = dp[m-1][n-1][0]
        return max_product % MOD if max_product >= 0 else -1