from collections import deque

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        directions = [(1, 0), (0, 1)]
        dp = [[-1] * (k + 1) for _ in range(m)]
        dp[0][0] = 0
        
        for cost in range(k + 1):
            for i in range(m):
                for j in range(n):
                    if dp[i][cost] != -1:
                        for di, dj in directions:
                            ni, nj = i + di, j + dj
                            if ni < m and nj < n:
                                new_cost = cost
                                if grid[ni][nj] == 1:
                                    new_cost += 1
                                elif grid[ni][nj] == 2:
                                    new_cost += 1
                                if new_cost <= k:
                                    new_score = dp[i][cost] + grid[ni][nj]
                                    dp[ni][new_cost] = max(dp[ni][new_cost], new_score)
        
        max_score = max(dp[m - 1])
        return max_score if max_score != -1 else -1